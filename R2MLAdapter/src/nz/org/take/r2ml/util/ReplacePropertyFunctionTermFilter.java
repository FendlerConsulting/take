/*
 * Copyright 2007 Bastian Schenke Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.r2ml.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.commons.collections.iterators.ArrayIterator;

import nz.org.take.r2ml.R2MLDriver;
import nz.org.take.r2ml.R2MLException;
import de.tu_cottbus.r2ml.AssociationAtom;
import de.tu_cottbus.r2ml.Atom;
import de.tu_cottbus.r2ml.AttributeFunctionTerm;
import de.tu_cottbus.r2ml.AttributionAtom;
import de.tu_cottbus.r2ml.DataClassificationAtom;
import de.tu_cottbus.r2ml.DataOperationTerm;
import de.tu_cottbus.r2ml.DataTerm;
import de.tu_cottbus.r2ml.DataValue;
import de.tu_cottbus.r2ml.DataVariable;
import de.tu_cottbus.r2ml.DatatypeFunctionTerm;
import de.tu_cottbus.r2ml.DatatypePredicateAtom;
import de.tu_cottbus.r2ml.DerivationRule;
import de.tu_cottbus.r2ml.DerivationRuleSet;
import de.tu_cottbus.r2ml.EqualityAtom;
import de.tu_cottbus.r2ml.GenericAtom;
import de.tu_cottbus.r2ml.GenericFunctionTerm;
import de.tu_cottbus.r2ml.InequalityAtom;
import de.tu_cottbus.r2ml.ObjectClassificationAtom;
import de.tu_cottbus.r2ml.ObjectDescriptionAtom;
import de.tu_cottbus.r2ml.ObjectFactory;
import de.tu_cottbus.r2ml.ObjectOperationTerm;
import de.tu_cottbus.r2ml.ObjectTerm;
import de.tu_cottbus.r2ml.ObjectVariable;
import de.tu_cottbus.r2ml.PropertyAtom;
import de.tu_cottbus.r2ml.QfAndOrNafNegFormula;
import de.tu_cottbus.r2ml.QfConjunction;
import de.tu_cottbus.r2ml.QfDisjunction;
import de.tu_cottbus.r2ml.QfNegationAsFailure;
import de.tu_cottbus.r2ml.QfStrongNegation;
import de.tu_cottbus.r2ml.ReferencePropertyAtom;
import de.tu_cottbus.r2ml.ReferencePropertyFunctionTerm;
import de.tu_cottbus.r2ml.RuleBase;
import de.tu_cottbus.r2ml.RuleSet;
import de.tu_cottbus.r2ml.Subject;
import de.tu_cottbus.r2ml.Term;

public class ReplacePropertyFunctionTermFilter implements RuleBaseFilter {
	
	Map<QName, Integer> propertyNames = new HashMap<QName, Integer>();

	ObjectFactory of = new ObjectFactory();

	Stack<List<Atom>> varBindings = new Stack<List<Atom>>();

	public String getName() {
		return "ReplacePropertyAndAttributionFunctionTerms";
	}

	public void repair(RuleBase ruleBase) throws R2MLException {
		if (R2MLDriver.get().logger.isDebugEnabled())
			R2MLDriver.get().logger.debug("replace property function terms");
		for (JAXBElement<? extends RuleSet> ruleSet : ruleBase.getRuleSet()) {
			if (!(ruleSet.getValue() instanceof DerivationRuleSet))
				// skip all non DerivationRuleSets
				continue;
			DerivationRuleSet dRuleSet = (DerivationRuleSet) ruleSet.getValue();
			for (DerivationRule rule : dRuleSet.getDerivationRule()) {
				if (R2MLDriver.get().logger.isDebugEnabled())
					R2MLDriver.get().logger.debug("replace property function terms in rule " + rule.getRuleID());
				fixFormula(rule.getConditions().getQfAndOrNafNegFormula());
				//handle(rule.getConclusion().getAtom().getValue());
			}
		}
	}

	/**
	 * check all Atoms in the formula for occurences of property terms
	 * 
	 * @param qfAndOrNafNegFormula
	 * @throws R2MLException
	 */
	@SuppressWarnings("unchecked")
	private void fixFormula(
			List<JAXBElement<? extends QfAndOrNafNegFormula>> qfAndOrNafNegFormula)
			throws R2MLException {
		//List<Atom> bindings = new ArrayList<Atom>();
		
		int i = 0;
		for (Object f : qfAndOrNafNegFormula.toArray()) {
			varBindings.push(new ArrayList<Atom>());
			JAXBElement formula = ((JAXBElement)f);
			Class<? extends QfAndOrNafNegFormula> type = formula.getDeclaredType();
			if (DatatypePredicateAtom.class.isAssignableFrom(type)) {
				if (R2MLUtil.isBooleanPredicate((DatatypePredicateAtom)formula.getValue())) {
					;;// ignore this case The DatatypePredicateHandler will do the rest
				} else {
					handle((Atom)formula.getValue());
				}
			} else if (Atom.class.isAssignableFrom(type)) {
				handle((Atom) formula.getValue());
			} else if (QfConjunction.class.isAssignableFrom(type)) {
				fixFormula(((QfConjunction) (formula.getValue()))
						.getQfAndOrNafNegFormula());
			} else if (QfDisjunction.class.isAssignableFrom(type)) {
				fixFormula(((QfDisjunction) (formula.getValue()))
						.getQfAndOrNafNegFormula());
			} else if (QfNegationAsFailure.class.isAssignableFrom(type)) {
				QfNegationAsFailure qfNegationAsFailure = ((QfNegationAsFailure) (formula
						.getValue()));
				Atom atom = qfNegationAsFailure.getAtom().getValue();
				handle(atom);
			} else if (QfStrongNegation.class.isAssignableFrom(type)) {
				QfStrongNegation qfStrongNegation = ((QfStrongNegation) (formula
						.getValue()));
				Atom atom = qfStrongNegation.getAtom().getValue();
				handle(atom);
			} else {
				throw new R2MLException("unable to check type "
						+ type.getName() + " for occurences of FunctionTerms.");
			}
			addVarBindings(qfAndOrNafNegFormula, i++);
		}
	}

	/**
	 * Add the bindings of the currently processed formula (topmost list on
	 * stack) and pop it away.
	 * 
	 * @param qfAndOrNafNegFormula
	 * @param i
	 * @throws R2MLException 
	 */
	@SuppressWarnings("unchecked")
	private void addVarBindings(
			List<JAXBElement<? extends QfAndOrNafNegFormula>> qfAndOrNafNegFormula,
			int i) throws R2MLException {
		//System.out.println("add " + varBindings.peek().size() + "varbindings");
		for (Atom binding : varBindings.pop()) {
			XmlType type = binding.getClass().getAnnotation(XmlType.class);

			if (type == null)
				throw new IllegalStateException();
			JAXBElement e = createJAXBElement(binding);
			qfAndOrNafNegFormula.add(i++, e);
		}
	}

	/**
	 * @param binding
	 * @return
	 * @throws R2MLException 
	 */
	private JAXBElement createJAXBElement(Atom binding) throws R2MLException {
//		JAXBElement e = new JAXBElement(new QName(type.namespace(), type
//				.name()), binding.getClass(), binding);
		if (binding instanceof AttributionAtom) {
			return of.createAttributionAtom((AttributionAtom)binding);
		} else if (binding instanceof ReferencePropertyAtom) {
			return of.createReferencePropertyAtom((ReferencePropertyAtom) binding);
		} else
			throw new R2MLException("illegal argument binding. must be Attribution- or ReferencePropertyAtom but is " + binding.getClass().getSimpleName());
	}

	/**
	 * @param atom
	 *            an Atom possibly containing a Reference or
	 *            AttributeFunctionTerm
	 * @return Atoms that bind inserted variables
	 * @throws R2MLException
	 */
	@SuppressWarnings("unchecked")
	private void handle(Atom atom) throws R2MLException {

		Class<? extends Atom> type = atom.getClass();

		if (DataClassificationAtom.class.isAssignableFrom(type)) {
			DataClassificationAtom dataClassificationAtom = ((DataClassificationAtom) atom);

			JAXBElement<? extends DataTerm> t = (JAXBElement<? extends DataTerm>) handle(dataClassificationAtom.getDataTerm());
			if (t != null) {
				dataClassificationAtom.setDataTerm(t);
			}
		} else if (DatatypePredicateAtom.class.isAssignableFrom(type)) {
			DatatypePredicateAtom datatypePredicateAtom = ((DatatypePredicateAtom) atom);
			if (R2MLUtil.isBooleanPredicate(datatypePredicateAtom)) {
				// do nothing the DatatypePredicateAtomHandler will handle this artefact
				return;
			}
			List<JAXBElement<? extends DataTerm>> datas = datatypePredicateAtom.getDataArguments().getDataTerm();
			handleDataArgs(datas);
//			for (JAXBElement<? extends DataTerm> t : datatypePredicateAtom
//					.getDataArguments().getDataTerm())
//				handle(t);
		} else if (AssociationAtom.class.isAssignableFrom(type)) {
			AssociationAtom aAtom = (AssociationAtom) atom;
			try {
				List<JAXBElement<? extends ObjectTerm>> objects = aAtom.getObjectArguments().getObjectTerm();
				handleObjectArgs(objects);
			} catch (NullPointerException e1) {
			}
			try {
				List<JAXBElement<? extends DataTerm>> datas = aAtom.getDataArguments().getDataTerm();
				handleDataArgs(datas);
			} catch (NullPointerException e) {
			}
		} else if (AttributionAtom.class.isAssignableFrom(type)) {
			AttributionAtom pAtom = (AttributionAtom) atom;
			JAXBElement<? extends ObjectTerm> subt = (JAXBElement<? extends ObjectTerm>) handle(pAtom.getSubject().getObjectTerm());
			if (subt != null) {
				Subject newSubject = of.createSubject();
				newSubject.setObjectTerm(subt);
				pAtom.setSubject(newSubject);
			}
			JAXBElement<?extends DataTerm> datT = (JAXBElement<? extends DataTerm>) handle(pAtom.getDataValue().getDataTerm());
			if (datT != null) {
				DataValue dv = of.createDataValue();
				dv.setDataTerm(datT);
				pAtom.setDataValue(dv);
			}
		} else if (EqualityAtom.class.isAssignableFrom(type)) {
			EqualityAtom eAtom = (EqualityAtom) atom;
			List<JAXBElement<? extends ObjectTerm>> objects = eAtom.getObjectTerm();
			handleObjectArgs(objects);
//			for (JAXBElement<? extends ObjectTerm> t : eAtom.getObjectTerm()) {
//				handle(t);
//			}
		} else if (InequalityAtom.class.isAssignableFrom(type)) {
			InequalityAtom iAtom = (InequalityAtom) atom;
			List<JAXBElement<? extends ObjectTerm>> objects = iAtom.getObjectTerm();
			handleObjectArgs(objects);
		} else if (ObjectClassificationAtom.class.isAssignableFrom(type)) {
			ObjectClassificationAtom oAtom = (ObjectClassificationAtom) atom;
			JAXBElement<? extends ObjectTerm> objt = (JAXBElement<? extends ObjectTerm>) handle(oAtom.getObjectTerm());
			if (objt != null) {
				oAtom.setObjectTerm(objt);
			}
		} else if (ObjectDescriptionAtom.class.isAssignableFrom(type)) {
			// ObjectDescriptionAtom oAtom = (ObjectDescriptionAtom) atom;
			throw new R2MLException("ObjectDescriptionAtom is not supported");
			// TODO build an AttributionAtom respectivly a ReferencePropertyAtom
			// for each slot
		} else if (PropertyAtom.class.isAssignableFrom(type)) {
			throw new R2MLException("Generic PropertyAtom is not supported.");
		} else if (ReferencePropertyAtom.class.isAssignableFrom(type)) {
			ReferencePropertyAtom pAtom = (ReferencePropertyAtom) atom;
			JAXBElement<? extends ObjectTerm> subt = (JAXBElement<? extends ObjectTerm>) handle(pAtom.getSubject().getObjectTerm());
			if (subt != null) {
				Subject newSubject = of.createSubject();
				newSubject.setObjectTerm(subt);
				pAtom.setSubject(newSubject);
			}
			JAXBElement<?extends ObjectTerm> objt = (JAXBElement<? extends ObjectTerm>) handle(pAtom.getObject().getObjectTerm());
			if (objt != null) {
				de.tu_cottbus.r2ml.Object newObject = of.createObject();
				newObject.setObjectTerm(objt);
				pAtom.setObject(newObject);
			}
		} else if (GenericAtom.class.isAssignableFrom(type)) {
			GenericAtom gAtom = (GenericAtom) atom;
			for (JAXBElement<? extends Term> t : gAtom.getArguments().getTerm()) {
				if (ObjectTerm.class.isAssignableFrom(t.getDeclaredType())) {
					handle(t);
				} else {
					handle(t);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private JAXBElement<? extends Term> handle(JAXBElement<? extends Term> value) throws R2MLException {
		// return nothing if this Term is not a PropertyTerm
		JAXBElement<? extends Term> ret = null;
		if (value.getDeclaredType().equals(AttributeFunctionTerm.class)) {
//			 TODO check arguments of the FunctionTerm for nested FunctionTerms 
			AttributeFunctionTerm t = (AttributeFunctionTerm) value.getValue();
			DataVariable var = of.createDataVariable();
			var.setDatatypeID(getDatatypeID(t));
			var.setName(generateVarName(t.getAttributeID()));
			var.setTypeCategory(value.getValue().getTypeCategory());
			AttributionAtom atom = of.createAttributionAtom();
			atom.setAttributeID(t.getAttributeID());
			Subject subject = of.createSubject();
			JAXBElement<? extends ObjectTerm> subTerm = (JAXBElement<? extends ObjectTerm>) handle(t.getContextArgument().getObjectTerm());
			if (subTerm != null) {
				subject.setObjectTerm(subTerm);
			} else {
				subject.setObjectTerm(t.getContextArgument().getObjectTerm());
			}
			atom.setSubject(subject);
			DataValue dValue = of.createDataValue();
			dValue.setDataTerm(of.createDataVariable(var));
			atom.setDataValue(dValue);
			
			varBindings.peek().add(atom);
			
			// return the variable
			ret = atom.getDataValue().getDataTerm();
			
		} else if (value.getDeclaredType().equals(ReferencePropertyFunctionTerm.class)) {
//			 TODO check arguments of the FunctionTerm for more FunctionTerms 
			ReferencePropertyFunctionTerm t = (ReferencePropertyFunctionTerm) value.getValue();
			ObjectVariable var = of.createObjectVariable();
			var.setClassID(getClassID(t));
			var.setName(generateVarName(t.getReferencePropertyID()));
			var.setTypeCategory(value.getValue().getTypeCategory());
			ReferencePropertyAtom atom = of.createReferencePropertyAtom();
			atom.setReferencePropertyID(t.getReferencePropertyID());
			Subject subject = of.createSubject();
			JAXBElement<? extends ObjectTerm> subTerm = (JAXBElement<? extends ObjectTerm>) handle(t.getContextArgument().getObjectTerm());
			if (subTerm != null) {
				subject.setObjectTerm(subTerm);
			} else {
				subject.setObjectTerm(t.getContextArgument().getObjectTerm());
			}
			atom.setSubject(subject);
			de.tu_cottbus.r2ml.Object obj = of.createObject();
			obj.setObjectTerm(of.createObjectVariable(var));
			atom.setObject(obj);
			
			varBindings.peek().add(atom);
			
			// rerturn the variable
			ret = atom.getObject().getObjectTerm();
		} else if (value.getDeclaredType().equals(DataOperationTerm.class)) {
			DataOperationTerm t = (DataOperationTerm) value.getValue();
			JAXBElement<? extends ObjectTerm> contextTerm = (JAXBElement<? extends ObjectTerm>) handle(t.getContextArgument().getObjectTerm());
			if (contextTerm != null) {
				t.getContextArgument().setObjectTerm(contextTerm);
			}
			List<JAXBElement<? extends Term>> args = t.getArguments().getTerm();
			handleArgs(args);
		} else if (value.getDeclaredType().equals(DatatypeFunctionTerm.class)) {
			DatatypeFunctionTerm t = (DatatypeFunctionTerm) value.getValue();
			List<JAXBElement<? extends DataTerm>> datas = t.getDataArguments().getDataTerm();
			handleDataArgs(datas);
		} else if (value.getDeclaredType().equals(GenericFunctionTerm.class)) {
			GenericFunctionTerm t = (GenericFunctionTerm) value.getValue();
			List<JAXBElement<? extends Term>> args = t.getArguments().getTerm();
			handleArgs(args);			
		} else if (value.getDeclaredType().equals(ObjectOperationTerm.class)) {
			ObjectOperationTerm t = (ObjectOperationTerm) value.getValue();
			JAXBElement<? extends ObjectTerm> contextTerm = (JAXBElement<? extends ObjectTerm>) handle(t.getContextArgument().getObjectTerm());
			if (contextTerm != null) {
				t.getContextArgument().setObjectTerm(contextTerm);
			}
			handleArgs(t.getArguments().getTerm());
		}
		// nothing to return if the term is not a PropertyTerm, else return a variable
		return ret;
	}

	/**
	 * @param args
	 * @throws R2MLException 
	 */
	private void handleArgs(List<JAXBElement<? extends Term>> args) throws R2MLException {
		Iterator<JAXBElement<? extends Term>> i = new ArrayIterator(args.toArray());
		//Iterator<JAXBElement<? extends Term>> i = args.listIterator();
		while (i.hasNext()) {
			JAXBElement<? extends Term> nextT = i.next();
			JAXBElement<? extends Term> newTerm = (JAXBElement<? extends Term>) handle(nextT);
			if (newTerm != null) {
				int indexOf = args.indexOf(nextT);
				//System.out.println("replace " + nextT.getValue().getClass().getSimpleName() + " with " + newTerm.getValue().getClass().getSimpleName());
				args.remove(indexOf);
				args.add(indexOf, newTerm);
				
//				i.remove();
			}
		}
	}

	/**
	 * @param objects
	 * @throws R2MLException
	 */
	private void handleObjectArgs(List<JAXBElement<? extends ObjectTerm>> objects) throws R2MLException {
		Iterator<JAXBElement<? extends ObjectTerm>> i = new ArrayIterator(objects.toArray());
		//Iterator<JAXBElement<? extends ObjectTerm>> i = objects.listIterator();
		while (i.hasNext()) {
			JAXBElement<? extends ObjectTerm> nextT = i.next();
			JAXBElement<? extends ObjectTerm> objT = (JAXBElement<? extends ObjectTerm>) handle(nextT);
			if (objT != null) {
				int indexOf = objects.indexOf(nextT);
				//System.out.println("replace " + nextT.getValue().getClass().getSimpleName() + " with " + objT.getValue().getClass().getSimpleName());
				objects.remove(indexOf);
				objects.add(indexOf, objT);
			}
		}
	}

	/**
	 * @param datas
	 * @throws R2MLException
	 */
	private void handleDataArgs(List<JAXBElement<? extends DataTerm>> datas) throws R2MLException {
		Iterator<JAXBElement<? extends DataTerm>> i = new ArrayIterator(datas.toArray());
		
		//Iterator<JAXBElement<? extends DataTerm>> i2 = datas.listIterator();
		while (i.hasNext()) {
			JAXBElement<? extends DataTerm> nextT = i.next();
			JAXBElement<? extends DataTerm> datT = (JAXBElement<? extends DataTerm>) handle(nextT);
			if (datT != null) {
				int indexOf = datas.indexOf(nextT);
				//System.out.println("replace " + nextT.getValue().getClass().getSimpleName() + " with variable " + ((DataVariable)(datT.getValue())).getName() );
				datas.remove(indexOf);
				datas.add(indexOf, datT);
			}
		}
	}

	private QName getClassID(ReferencePropertyFunctionTerm t) throws R2MLException {
		//QName type = getClassId(t.getContextArgument().getObjectTerm().getValue());
		QName propId = t.getReferencePropertyID();
		return R2MLUtil.getPropertyType(propId);
	}

	private QName getDatatypeID(AttributeFunctionTerm t) throws R2MLException {		
		return R2MLUtil.getPropertyType(t.getAttributeID());
	}

	private String generateVarName(QName propertyName) {
		Integer i = propertyNames.get(propertyName);
		if (i==null) {
			i=0;
		}
		propertyNames.put(propertyName, ++i);
		return propertyName.getLocalPart() + i;
	}

}

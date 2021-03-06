/*
 * Copyright 2007 Bastian Schenke Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.r2ml.reference;

import de.tu_cottbus.r2ml.AssociationAtom;
import nz.org.take.Fact;
import nz.org.take.Predicate;
import nz.org.take.Prerequisite;
import nz.org.take.Term;
import nz.org.take.r2ml.AbstractPropertyHandler;
import nz.org.take.r2ml.AssociationResolvPolicy;
import nz.org.take.r2ml.MappingContext;
import nz.org.take.r2ml.R2MLDriver;
import nz.org.take.r2ml.R2MLException;
import nz.org.take.r2ml.XmlTypeHandler;
import nz.org.take.r2ml.util.R2MLUtil;

/**
 * This AssociationResolvPolicy builds Facts and Prerequisites for Associations
 * as if they would be ReferenceProperties. Note: For now only binary one-to-one
 * associations are supported. DataTerms are ignored.
 * 
 * <ul>
 * <li>build property predicate for ObjectTerms in documentorder</li>
 * <li>if no predicate is built (no bean properties in the Java classes)
 * fallback to SimpleAssociationResolvPolicy</li>
 * <li>build facts for the created predicate(s)</li>
 * </ul>
 * 
 * @author schenke
 */
public class AssociationAsReferenceResolvPolicy extends AbstractPropertyHandler implements
		AssociationResolvPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.take.r2ml.AssociationResolvPolicy#resolv(de.tu_cottbus.r2ml.AssociationAtom)
	 */
	public Fact resolv(AssociationAtom atom) throws R2MLException {

		if (atom.getObjectArguments().getObjectTerm().size() != 2) {
			throw new R2MLException(
					"This policy handles only binary associations.");
		}

		R2MLDriver driver = R2MLDriver.get();

		MappingContext context = MappingContext.get();

		XmlTypeHandler handler0 = driver.getHandlerByXmlType(atom
				.getObjectArguments().getObjectTerm().get(0).getDeclaredType());
		XmlTypeHandler handler1 = driver.getHandlerByXmlType(atom
				.getObjectArguments().getObjectTerm().get(1).getDeclaredType());

		Term arg0 = (Term) handler0.importObject(atom.getObjectArguments()
				.getObjectTerm().get(0).getValue());
		Term arg1 = (Term) handler1.importObject(atom.getObjectArguments()
				.getObjectTerm().get(1).getValue());

		String name = atom.getAssociationPredicateID().getLocalPart();
		String[] slotNames = driver.getNameMapper().getSlotNames(atom.getAssociationPredicateID());
		Predicate predicate = buildPredicate(arg0, arg1, name, R2MLUtil
				.isNegated(atom), slotNames);

		// no beanproperties exist
		Fact fact = R2MLUtil.newFact();

		if (predicate != null) {
			fact.setPredicate(predicate);
			fact.setTerms(new Term[] { arg0, arg1 });
			fact.setId(name);
		}

		return fact;
	}

	private Predicate buildPredicate(Term arg0, Term arg1,
			String associationName, boolean negated, String[] slotNames) throws R2MLException {
		Term domain = arg0;
		Term range = arg1;
		Predicate predicate = null;
		try {
			predicate = buildPredicate(associationName,
					domain, range, negated, slotNames);
		} catch (ClassCastException cce) {
			System.out.println("ClassCastException in AssociationAsReferenceResolvPolicy");
		}
		return predicate;
	}

	public Object importObject(Object obj) throws R2MLException {
		throw new UnsupportedOperationException("This Methodcall is not allowed!");
		//return null;
	}

}

/*
 * Copyright 2007 Bastian Schenke Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.r2ml;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import nz.org.take.Fact;
import nz.org.take.JPredicate;
import nz.org.take.Predicate;
import nz.org.take.Term;
import nz.org.take.r2ml.util.R2MLUtil;
import de.tu_cottbus.r2ml.InequalityAtom;
import de.tu_cottbus.r2ml.ObjectTerm;

/**
 * @author Bastian Schenke (bastian.schenke@googlemail.com)
 */
class InequalityAtomHandler implements XmlTypeHandler {
	
	class InEqualityPair {
		InEqualityPair(ObjectTerm obj1, ObjectTerm obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
		}

		ObjectTerm obj1 = null;
		ObjectTerm obj2 = null;
	}

	/**
	 * Map an InEqualityAtom to a List of negated equals-Facts 
	 * 
	 * TODO implement protected Boolean isNegated;
	 * 
	 * @param obj
	 *            an InequalityAtom 
	 * @return a List of negated equals-Facts
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	public Object importObject(Object obj)
			throws R2MLException {
		InequalityAtom atom = (InequalityAtom)obj;
		if (atom.isIsNegated() != null && atom.isIsNegated())
			throw new R2MLException("Negation is not yet supported in InEqualityAtoms", R2MLException.FEATURE_NOT_YET_IMPLEMENTED);
		List<Fact> facts = new ArrayList<Fact>();
		try {
			for (InEqualityPair pair : getArgsAsPairs(atom.getObjectTerm())) {
				facts.add(buildFact(pair, MappingContext.get(), R2MLDriver.get()));
			}
		} catch (Exception e) {
			throw new R2MLException("Error while handling EqualityAtom!", e);
		}
		return facts;
	}

	private Fact buildFact(InEqualityPair pair, MappingContext context,
			R2MLDriver driver) throws R2MLException {
		XmlTypeHandler handler1 = driver.getHandlerByXmlType(pair.obj1
				.getClass());
		XmlTypeHandler handler2 = driver.getHandlerByXmlType(pair.obj2
				.getClass());
		Term term1 = (Term) handler1.importObject(pair.obj1);
		Term term2 = (Term) handler2.importObject(pair.obj2);
		Fact fact = R2MLUtil.newFact();
		fact.setTerms(new Term[] { term1, term2 });
		fact.setPredicate(buildInEqualsPredicate(term1, term2, driver));
		return fact;
	}

	private Predicate buildInEqualsPredicate(Term term1, Term term2, R2MLDriver driver) throws R2MLException {
		JPredicate jp = new JPredicate();
		Method method = R2MLUtil.getMethod(EQUALITY_CHECK_METHOD, new Term[]{term1, term2});
		jp.setMethod(method);
		jp.setNegated(true);
		return jp;
	}

	private List<InEqualityPair> getArgsAsPairs(
			List<JAXBElement<? extends ObjectTerm>> args) {
		List<InEqualityPair> pairs = new ArrayList<InEqualityPair>(args.size()
				* (args.size() - 1));
		for (JAXBElement<? extends ObjectTerm> i : args) {
			for (JAXBElement<? extends ObjectTerm> j : args) {
				if (!(i == j))
					pairs.add(new InEqualityPair(i.getValue(), j.getValue()));
			}
		}
		return pairs;
	}
}

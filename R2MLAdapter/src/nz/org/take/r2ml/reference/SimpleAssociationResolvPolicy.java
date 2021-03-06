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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import de.tu_cottbus.r2ml.AssociationAtom;
import de.tu_cottbus.r2ml.DataTerm;
import de.tu_cottbus.r2ml.ObjectTerm;
import nz.org.take.Fact;
import nz.org.take.SimplePredicate;
import nz.org.take.Term;
import nz.org.take.r2ml.AssociationResolvPolicy;
import nz.org.take.r2ml.MappingContext;
import nz.org.take.r2ml.R2MLDriver;
import nz.org.take.r2ml.R2MLException;
import nz.org.take.r2ml.XmlTypeHandler;
import nz.org.take.r2ml.util.R2MLUtil;

/**
 * 
 * @author schenke
 *
 */
public class SimpleAssociationResolvPolicy implements AssociationResolvPolicy {

	public Fact resolv(AssociationAtom atom) throws R2MLException {
		
		R2MLDriver driver = R2MLDriver.get();
		MappingContext context = MappingContext.get();
		
		context.getPredicate(atom.getAssociationPredicateID().getLocalPart());
		Fact result = R2MLUtil.newFact();
		result.setId(atom.getAssociationPredicateID().getLocalPart());
		// build fact for association
		List<Term> terms = new ArrayList<Term>();
		List<Class> termTypes =  new ArrayList<Class>();
		// build all terms and types of terms
		for (JAXBElement<? extends ObjectTerm> objectTermElement : atom.getObjectArguments().getObjectTerm()) {
			XmlTypeHandler handler = driver.getHandlerByXmlType(objectTermElement.getDeclaredType());
			Term argument = null;
			try {
				argument = (Term) handler.importObject(objectTermElement.getValue());
				terms.add(argument);
				termTypes.add(argument.getType());
			} catch (ClassCastException e) {
				throw new R2MLException("Error while handling ObjectTerms for Association " + atom.getAssociationPredicateID(), e);
			}
		}
		
		for (JAXBElement<? extends DataTerm> dataTermElement : atom.getDataArguments().getDataTerm()) {
			XmlTypeHandler handler = driver.getHandlerByXmlType(dataTermElement.getDeclaredType());
			Term argument = null;
			try {
				argument = (Term) handler.importObject(dataTermElement.getValue());
				terms.add(argument);
				termTypes.add(argument.getType());
			} catch (ClassCastException e) {
				throw new R2MLException("Error while handling DataTerms for Association " + atom.getAssociationPredicateID(), e);
			}
		}
		// try to reuse predicate build earlier
		if (context.getPredicate(atom.getAssociationPredicateID().getLocalPart()) != null) {
			result.setPredicate(context.getPredicate(atom.getAssociationPredicateID().getLocalPart()));
		} else {
			// build new predicate
			SimplePredicate simpleAssociationPredicate = new SimplePredicate();
			simpleAssociationPredicate.setName(atom.getAssociationPredicateID().getLocalPart());
			simpleAssociationPredicate.setNegated(atom.isIsNegated() == null?false:atom.isIsNegated());
			simpleAssociationPredicate.setSlotNames(driver.getNameMapper().getSlotNames(atom.getAssociationPredicateID()));
			simpleAssociationPredicate.setSlotTypes(termTypes.toArray(new Class[] {}));
			result.setPredicate(simpleAssociationPredicate);
		}
		// apply terms
		result.setTerms(terms.toArray(new Term[] {}));
		return result;
	}

}

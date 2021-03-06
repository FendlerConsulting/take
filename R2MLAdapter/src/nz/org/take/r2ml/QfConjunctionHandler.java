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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;

import nz.org.take.Fact;
import nz.org.take.Prerequisite;
import nz.org.take.r2ml.util.R2MLUtil;
import de.tu_cottbus.r2ml.QfAndOrNafNegFormula;
import de.tu_cottbus.r2ml.QfConjunction;

/**
 * @author Bastian Schenke (bastian.schenke@googlemail.com)
 *
 */
public class QfConjunctionHandler implements XmlTypeHandler {

	/**
	 * Map a quantifier free conjunction from R2ML (QfConjunction) to a list of take
	 * prerequisites (List<Prerequisite>).
	 * If the disjunction still contains any formulas (nested conjunctions or negations) they will be flatened.
	 * 
	 * @param obj
	 *            a QfConjunction object
	 * @return a list of take prerequisites
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	@SuppressWarnings("unchecked")
	public Object importObject(Object obj) throws R2MLException {

		R2MLDriver driver = R2MLDriver.get();
		MappingContext context = MappingContext.get();
		List<Prerequisite> prereqs = new ArrayList<Prerequisite>();
		
		try {
			QfConjunction formula = (QfConjunction)obj;
			for (JAXBElement<? extends QfAndOrNafNegFormula> item : formula.getQfAndOrNafNegFormula()) {
				XmlTypeHandler handler = driver.getHandlerByXmlType(item.getValue().getClass());
				Object takeArtefact = handler.importObject(item.getValue());
				if (takeArtefact instanceof Collection)
					prereqs.addAll((List<Prerequisite>)takeArtefact);
				else
					prereqs.add(R2MLUtil.factAsPrerequisite((Fact)takeArtefact));
			}
		} catch (ClassCastException e) {
			//throw new R2MLException("Wrong XmlTypeHandler [" + handler.getClass() + "] for [" + obj.getClass() + "]", R2MLException.CLASS_CAST_ERROR);
		}

		return prereqs;
	}

}

/*
 * Copyright (C) 2007 Bastian Schenke (bastian.schenke(at)gmail.com) and 
 * <a href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package nz.org.take.r2ml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.tu_cottbus.r2ml.Atom;
import nz.org.take.DerivationRule;
import nz.org.take.Fact;
import nz.org.take.Prerequisite;

/**
 * @author Bastian Schenke (bastian.schenke@googlemail.com)
 * 
 */
class DerivationRuleHandler implements XmlTypeHandler {

	/**
	 * Map a de.tu_cottbus.r2ml.DerivationRule to a List of
	 * nz.ac.take.DerivationRule. If the body of the Rule contains a Disjunction
	 * it is splitted into two or more separated rules (take does not supprt
	 * disjunctions in the body).
	 * 
	 * FIXME disjunction in conditions of r2ml rules means more than one rule in
	 * take
	 * 
	 * @param obj
	 *            a r2ml.DerivationRule object
	 * @param driver
	 *            the used R2MLDriver
	 * @return List<nz.ac.take.DerivationRule> one rule for each disjunct in the condition
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	public List<DerivationRule> importObject(Object obj, MappingContext context, R2MLDriver driver)
			throws R2MLException {

		// R2ML DerivationRule
		de.tu_cottbus.r2ml.DerivationRule xDRule = (de.tu_cottbus.r2ml.DerivationRule) obj;
		
		// take DerivationRule
		List<DerivationRule> dRules = new ArrayList<DerivationRule>();

		// Documentation
		Map<String, String> documentation = extractDocumentation(xDRule, context, driver);
		Fact head = extractHead(xDRule, context, driver);
		
		try {
			int i = 0;
			List<List<Prerequisite>> body = extractBody(xDRule, context, driver);
			for (List<Prerequisite> condition : body) {
				DerivationRule dRule = new DerivationRule();
				// Condition
				dRule.setBody(condition);
				// Conclusion
				dRule.setHead(head);
				// copy RuleID
				if (body.size() != 1)
					dRule.setId(xDRule.getRuleID() + '_' + i++);
				else
					dRule.setId(xDRule.getRuleID());
				// add documentation
				dRule.addAnnotations(documentation);
				dRules.add(dRule);
			} // for
		} catch (R2MLException e) {
			throw new R2MLException("Unable to map Derivationrule (" + xDRule.getRuleID() + ")", e);
		} // try catch

		return dRules;
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> extractDocumentation(
			de.tu_cottbus.r2ml.DerivationRule rule, MappingContext context, R2MLDriver driver)
			throws R2MLException {

		Map<String, String> docAnnotations = null;
		XmlTypeHandler handler = null;
		try {
			handler = driver.getHandlerByXmlType(rule.getDocumentation()
					.getClass());
			docAnnotations = (Map<String, String>) handler.importObject(rule
					.getDocumentation(), context, driver);
		} catch (NullPointerException e) {
			driver.logger.info("No documentation element for rule "
					+ (rule.getRuleID() != null ? rule.getRuleID() : rule
							.toString()));
			docAnnotations = new HashMap<String, String>();
		}
		return docAnnotations;
	}

	private Fact extractHead(de.tu_cottbus.r2ml.DerivationRule rule, MappingContext context,
			R2MLDriver driver) throws R2MLException {
		Fact head = null;
		Atom atom = rule.getConclusion().getAtom().getValue();
		XmlTypeHandler handler = driver.getHandlerByXmlType(atom.getClass());
		head = (Fact) handler.importObject(atom, context, driver);
		return head;
	}

	@SuppressWarnings("unchecked")
	private List<List<Prerequisite>> extractBody(
			de.tu_cottbus.r2ml.DerivationRule rule, MappingContext context, R2MLDriver driver)
			throws R2MLException {
		List<List<Prerequisite>> body = null;
		XmlTypeHandler handler = driver.getHandlerByXmlType(rule.getConditions().getClass());
		body = (List<List<Prerequisite>>) handler.importObject(rule.getConditions(), context, driver);
		return body;
	}

}
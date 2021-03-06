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

import nz.org.take.KnowledgeBase;
import nz.org.take.Query;
import nz.org.take.r2ml.util.AbstractQueryGenerator;

/**
 * A Querygenerator generating all possible queries for all predicates
 * supported by the knowledgebase.
 * 
 * @author Bastian Schenke (bastian.schenke(at)googlemail.com)
 *
 */
public class DefaultQueryGenerator extends AbstractQueryGenerator {

	/**
	 * 
	 */
	public DefaultQueryGenerator() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see nz.org.take.r2ml.util.QueryGenerator#generateQueries(nz.org.take.KnowledgeBase)
	 */
	public void generateQueries(KnowledgeBase kb) {
		for (Query q : buildAllQueries(kb.getSupportedPredicates())) {
			kb.add(q);
		}

	}

}

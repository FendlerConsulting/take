/**
 * Copyright 2007 Jens Dietrich Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */

package nz.org.take;

/**
 * Visitor for knowledge bases.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */
public interface KnowledgeBaseVisitor {
	
	public boolean visit(KnowledgeBase kb);
	public void endVisit(KnowledgeBase kb);
	public boolean visit(DerivationRule r);
	public void endVisit(DerivationRule r);
	public boolean visit(ExternalFactStore k);
	public void endVisit(ExternalFactStore k);
	public boolean visit(Fact f);
	public void endVisit(Fact f);
	public boolean visit(ComplexTerm t);
	public void endVisit(ComplexTerm t);
	public boolean visit(Constant t);
	public void endVisit(Constant t);
	public boolean visit(Variable t);
	public void endVisit(Variable t);
	public boolean visit(Query q);
	public void endVisit(Query q);
	public boolean visit(ExpressionPrerequisite p);
	public void endVisit(ExpressionPrerequisite p);
	public boolean visit(FactPrerequisite p);
	public void endVisit(FactPrerequisite p);
	
}

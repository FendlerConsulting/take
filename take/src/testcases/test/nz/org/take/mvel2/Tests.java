/**
 * Copyright 2009 Jens Dietrich Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */

package test.nz.org.take.mvel2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import nz.org.take.ExpressionPrerequisite;
import nz.org.take.ComplexTerm;
import nz.org.take.ExpressionException;
import nz.org.take.mvel2.MVEL2ExpressionLanguage;


/**
 * Tests for MVEL2 based expressions.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class Tests {
	public static final String MVEL2 = MVEL2ExpressionLanguage.class.getName();
	private ExpressionPrerequisite createExpressionPrerequisite(String expression,String var1,Class type1) throws ExpressionException {
		Map<String, Class> typeInfo = new HashMap<String, Class>();
		typeInfo.put(var1,type1);
		return new ExpressionPrerequisite(expression,MVEL2, typeInfo);
	}
	private ExpressionPrerequisite createExpressionPrerequisite(String expression,String var1,Class type1,String var2,Class type2) throws ExpressionException {
		Map<String, Class> typeInfo = new HashMap<String, Class>();
		typeInfo.put(var1,type1);
		typeInfo.put(var2,type2);
		return new ExpressionPrerequisite(expression,MVEL2, typeInfo);
	}
	private ComplexTerm createComplexTerm(String expression,String var1,Class type1,String var2,Class type2) throws ExpressionException {
		Map<String, Class> typeInfo = new HashMap<String, Class>();
		typeInfo.put(var1,type1);
		typeInfo.put(var2,type2);
		return new ComplexTerm(expression,MVEL2, typeInfo);
	}
	@Test
	public void testExpressionPrerequisite1() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.getName()==q.getName()","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
		assertTrue(x.getInputSlots().contains("q"));
	}
	@Test
	public void testExpressionPrerequisite2() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.name==q.name","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
		assertTrue(x.getInputSlots().contains("q"));
	}
	// must fail - should return a boolean but returns a string
	@Test(expected= ExpressionException.class)
	public void testExpressionPrerequisite3() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.getName()","p",Person.class,"q",Person.class);

	}
	// must fail - non existing property
	@Test(expected= ExpressionException.class)
	public void testExpressionPrerequisite4() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.property","p",Person.class,"q",Person.class);

	}
	@Test
	public void testExpressionPrerequisite5() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.male","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
	}
	@Test
	public void testExpressionPrerequisite6() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.male","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
		// q is not actually used in the expression, so it should not show up here!
		assertFalse(x.getInputSlots().contains("q"));
	}
	// uses literals in expression
	@Test
	public void testExpressionPrerequisite7() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.name=='Max'","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
	}
	// unused variable name is part of literal in expression
	@Test
	public void testExpressionPrerequisite8() throws Exception {
		ExpressionPrerequisite x = createExpressionPrerequisite("p.name=='q'","p",Person.class,"q",Person.class);
		assertEquals(Boolean.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
		assertFalse(x.getInputSlots().contains("q"));
	}
	
	@Test
	public void testComplexTerm1() throws Exception {
		ComplexTerm x = createComplexTerm("p.getName()","p",Person.class,"q",Person.class);
		assertEquals(String.class,x.getType());
		assertTrue(x.getInputSlots().contains("p"));
	}
}

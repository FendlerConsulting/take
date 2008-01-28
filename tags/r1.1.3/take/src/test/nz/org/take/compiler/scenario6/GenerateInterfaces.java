/*
 * Copyright (C) 2007 <A href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
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


package test.nz.org.take.compiler.scenario6;

import org.apache.log4j.BasicConfigurator;
import nz.org.take.KnowledgeBase;
import nz.org.take.compiler.reference.DefaultCompiler;
import nz.org.take.compiler.util.jalopy.JalopyCodeFormatter;
import nz.org.take.script.ScriptException;
import nz.org.take.script.ScriptKnowledgeSource;


/**
 * Script to generate the interface for the test kb.
 * @see KBFactory
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class GenerateInterfaces {

	/**
	 * Generate the interface for the example.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		nz.org.take.compiler.Compiler compiler = new DefaultCompiler();
		compiler.add(new JalopyCodeFormatter());
		
		// generate kb
		KnowledgeBase kb = null;
		try {
			ScriptKnowledgeSource KSrc = new ScriptKnowledgeSource(Tests.class.getResourceAsStream("/test/nz/org/take/compiler/scenario6/rules6.take"));
			kb = KSrc.getKnowledgeBase();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		compiler.setPackageName("test.nz.org.take.compiler.scenario6.generated");
		compiler.setClassName("KB");
		compiler.compileInterface(kb);

	}
}
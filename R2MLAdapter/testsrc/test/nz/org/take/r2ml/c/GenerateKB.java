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


package test.nz.org.take.r2ml.c;

import org.apache.log4j.BasicConfigurator;
import nz.org.take.KnowledgeBase;
import nz.org.take.compiler.reference.DefaultCompiler;
import nz.org.take.compiler.util.DefaultLocation;
import nz.org.take.compiler.util.DefaultNameGenerator;
import nz.org.take.compiler.util.jalopy.JalopyCodeFormatter;
import nz.org.take.r2ml.R2MLException;
import nz.org.take.r2ml.R2MLKnowledgeSource;

/**
 * Script to generate the interface for the test kb.
 * @see KBFactory
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class GenerateKB {

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
			R2MLKnowledgeSource kSrc = new R2MLKnowledgeSource(GenerateKB.class.getResourceAsStream("/test/nz/org/take/r2ml/c/rulesc.xml"));
			kSrc.setDatatypeMapper(new MyDatatypeMapper());
			KBUtil.addQuerries(kSrc);
			kb = kSrc.getKnowledgeBase();
		} catch (R2MLException e) {
			e.printStackTrace();
		}
		compiler.add(new JalopyCodeFormatter());
		compiler.setLocation(new DefaultLocation("testsrc"));
		compiler.setNameGenerator(new DefaultNameGenerator());
		compiler.setPackageName("test.nz.org.take.r2ml.c.generated");
		compiler.setClassName("FamilyKB");
		compiler.compile(kb);

	}

}

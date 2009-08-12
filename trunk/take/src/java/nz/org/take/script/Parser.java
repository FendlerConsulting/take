/**
 * Copyright 2008 Jens Dietrich Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.script;

import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;

import nz.org.take.KnowledgeBase;

// Note: The Take parser and lexer classes are generated when the build script is run.
import nz.org.take.script.antlr.TakeLexer;
import nz.org.take.script.antlr.TakeParser;

/**
 * Wrapper class for the ANTLR based Take parser.
 */
public class Parser {
	
	private ClassLoader classLoader;
	
	public Parser() {
		super();
	}
	
	public KnowledgeBase parse(Reader reader) throws Exception {	
		TakeLexer lexer = new TakeLexer(new ANTLRReaderStream(reader));
		TakeParser parser = new TakeParser(new CommonTokenStream(lexer));
		
		return parser.script();
	}
}
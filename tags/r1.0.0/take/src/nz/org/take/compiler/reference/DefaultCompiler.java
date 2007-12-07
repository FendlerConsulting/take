/*
 * Copyright (C) 2006 <A href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
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

package nz.org.take.compiler.reference;

import java.io.PrintWriter;
import java.util.*;
import nz.org.take.compiler.*;
import nz.org.take.compiler.Compiler;
import nz.org.take.compiler.util.*;
import nz.org.take.rt.DerivationController;
import nz.org.take.*;

/**
 * Default compiler implementation.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class DefaultCompiler extends CompilerUtils  implements Compiler {
	
	private static final String RESULT = "result";
	
	// instance variable names
	private String varName4DerivationController = "_derivation";

	// custom settings
	private String derivationControllerClass = "DefaultDerivationController";
	private String[] derivationControllerInitialisationParameters = {}; // will be passed to the constructor of derivationControllerClass
	private List<Query> publicAgenda = new ArrayList<Query>();
	private Collection<Query> done = new ArrayList<Query>();
	private NameGenerator nameGenerator = new DefaultNameGenerator();
	private KnowledgeBase kb = null;
	private List<SourceTransformation> transformations = new ArrayList<SourceTransformation>();
	private Map<DerivationRule, String> bindingClassNames = new HashMap<DerivationRule, String>();
	private int bindingClassCounter = 1;
	private Map<String,String> methodNames4QueriesFromAnnotations = new HashMap<String,String>();
	private Map<String,ExternalFactStore> externalFactStores = null;
	private List<CompilerPlugin> plugins = new ArrayList<CompilerPlugin>();
	private Location location = new DefaultLocation();
	private String packageName = null;
	private String className = "_KB";
	private String[] interfaceNames = null;
	private String[] importStatements = null;
	private boolean generateDataClassesForQueryPredicates = true;
	private Set<Predicate> publicPredicates = null; // predicates referenced in queries
	
	/**
	 * Constructor.
	 */
	public DefaultCompiler()  {
		super();
		this.install(new CompilerPlugin4JPredicates(this));
		this.install(new CompilerPlugin4PropertyPredicates(this));
		this.install(new CompilerPlugin4Comparisons(this));
	}

	/**
	 * Create a public interface for the knowlegde base.
	 * This method will create an interface containing the public methods of the kb to be generated by the kb.
	 * it will also create the referenced types - the data types for the predicates referenced in the queries.
	 * @param kb a knowledge base
	 * @throws CompilerException
	 */
	public void compileInterface (KnowledgeBase kb) throws CompilerException  {
		this.kb = kb;
		// step1 - return types
		for (Predicate p:getPublicPredicates()) {
			String pClassName = getClassName(p);
			String fullClassName = packageName + "." + pClassName;
			PrintWriter out = new PrintWriter(location.getSrcOut(fullClassName));
			createReturnType(out, pClassName, packageName, p);
			out.close();
			endorseClazz(location, fullClassName);
		}
		
		// step2 - interfaces for external fact sets
		for (Map.Entry<String,ExternalFactStore>entry:this.getExternalFactStores().entrySet()) {
			String pClassName = getExternalDataStoreName(entry.getValue());
			String fullClassName = packageName +'.'+pClassName;
			PrintWriter out = new PrintWriter(location.getSrcOut(fullClassName));
			createExternalFactStoreType(out, pClassName, packageName, entry.getValue());
			out.close();
			endorseClazz(location, fullClassName);
		}
		
		// step2 - interface
		PrintWriter out = new PrintWriter(location.getSrcOut( packageName + "." + className));
		out.print("package ");
		out.print(packageName);
		out.println(";");
		out.println("import nz.org.take.rt.*;");
		
		// print additional imports
		printImports(out);
		
		out.println("/**");
		out.println(" * Interface generated by the take compiler. ");
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");
		out.println("@SuppressWarnings(\"unchecked\")");
		out.print("public interface ");
		out.print(className);
		
		if (this.interfaceNames!=null && this.interfaceNames.length>0) {
			out.print(" extends ");
			printCommaSeparatedList(out,this.interfaceNames);
		}
		
		out.println("{");
		// abstract methods
		for (Query q:kb.getQueries()) {
			createPublicMethod(out,q,false);
		}

		out.println("}");
		out.close();
		String fullClassName = packageName + "." + className;
		endorseClazz(location, fullClassName);
	}
	/**
	 * Compile the kb.
	 * @param kb a knowledge base
	 * @throws CompilerException
	 */
	public void compile(KnowledgeBase kb)throws CompilerException {

		// put queries to publicAgenda (necessity is checked implicit)
		for (Query q : kb.getQueries()) {
			this.addToAgenda(q);
			// cache method names from annotation so that queries that are built later
			// can use the same annotations
			String methodName = q.getAnnotation(AnnotationKeys.TAKE_GENERATE_METHOD);
			if (methodName!=null) {
				String k = this.createQueryHash(q);
				methodNames4QueriesFromAnnotations.put(k, methodName);
			}
		}
		String fullClassName = packageName + "." + className;
		String constantRegistryClassName = packageName + "." + nameGenerator.getConstantRegistryClassName();
		String factStoreRegistryClassName = packageName + "." + nameGenerator.getFactStoreRegistryClassName();
		this.kb = kb;
		try {
			PrintWriter out = new PrintWriter(location.getSrcOut(constantRegistryClassName));
			createConstantsRegistryClass(out,nameGenerator.getConstantRegistryClassName(), packageName);
			out.close();
			
			out = new PrintWriter(location.getSrcOut(factStoreRegistryClassName));
			createExternalFactStoresRegistryClass(out,nameGenerator.getFactStoreRegistryClassName(), packageName);
			out.close();
			
			out = new PrintWriter(location.getSrcOut(fullClassName));
			createKBClass(out, className, packageName);
			out.close();
			endorseClazz(location, fullClassName);

			// return types
			for (Predicate p:findPredicates(kb)) {
				if (!isGenerateDataClassesForQueryPredicates() && this.getPublicPredicates().contains(p)) {
					// already generated with interface
				}
				else {	
					className = getClassName(p);
					fullClassName = packageName + "." + className;
					out = new PrintWriter(location.getSrcOut(fullClassName));
					createReturnType(out, className, packageName, p);
					out.close();
					endorseClazz(location, fullClassName);
				}
			}

		} catch (Exception x) {
			throw new CompilerException(x);
		}
	}


	/**
	 * Create the class that holds the constants referenced in the kb.
	 * @param out the writer
	 * @param clazz the class name
	 * @param pck the package name
	 */
	private void createConstantsRegistryClass(PrintWriter out, String clazz, String pck) throws CompilerException {
		// pick up constant terms
		final Collection<Constant> constants = new HashSet<Constant>();
		AbstractKnowledgeBaseVisitor lookup = new AbstractKnowledgeBaseVisitor() {
			public boolean visit(Constant t) {
				super.visit(t);
				if (!t.isLiteral())
					constants.add(t);
				return true;
			}			
		};
		kb.accept(lookup);
		
		if (constants.isEmpty())
			return; // nothing to do
		
		out.print("package ");
		out.print(pck);
		out.println(";");
		out.println("/**");
		out.println(" * Class generated by the take compiler. ");
		out.println(" * This class holds the constants referenced in the knowledge base. ");
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");
		out.println("@SuppressWarnings(\"unchecked\")");
		out.print("public class ");
		out.print(clazz);
		out.println("{");

		for (Constant c:constants) {
			out.print("public static ");
			out.print(c.getType().getName());
			out.print(" ");
			out.print(c.getRef());
			out.println(';');
		}
		
		out.println("}");
	}
	
	/**
	 * Create the class that holds the fact stores referenced in the kb.
	 * @param out the writer
	 * @param clazz the class name
	 * @param pck the package name
	 */
	private void createExternalFactStoresRegistryClass(PrintWriter out, String clazz, String pck) throws CompilerException {
		// pick up external fact stores
		final Collection<ExternalFactStore> stores = new HashSet<ExternalFactStore>();
		KnowledgeBaseVisitor lookup = new AbstractKnowledgeBaseVisitor() {
			public boolean visit(ExternalFactStore fs) {
				super.visit(fs);
				stores.add(fs);
				return true;
			}
			public boolean visit(DerivationRule r) {
				return false;
			}	
			public boolean visit(Fact f) {
				return false;
			}	
			public boolean visit(Query q) {
				return false;
			}	
		};
		kb.accept(lookup);
		
		
		if (stores.isEmpty())
			return; // nothing to do
		
		out.print("package ");
		out.print(pck);
		out.println(";");
		out.println("/**");
		out.println(" * Class generated by the take compiler. ");
		out.println(" * This class holds the fact stores referenced in the knowledge base. ");
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");
		out.println("@SuppressWarnings(\"unchecked\")");
		out.print("public class ");
		out.print(clazz);
		out.println("{");
		
		// the package name of the type referenced is the package
		// name of the interface
	
		for (ExternalFactStore fs:stores) {
			String pClassName = getExternalDataStoreName(fs);
			
			// look for package where interfaces are located
			String fullClassName = null;
			if (this.interfaceNames==null)
				throw new CompilerException("Cannot find interface for external fact stores - no interface package set");
			
			for (String i:this.interfaceNames) {
				try {
					Class intfc = Class.forName(i);
					String iPck = intfc.getPackage().getName();
					String fpClassName = iPck+'.'+pClassName;
					try {
						Class.forName(fpClassName);
						fullClassName=fpClassName;
					}
					catch (ClassNotFoundException x) {}
				}
				catch (ClassNotFoundException x) {
					throw new CompilerException("Cannot find interface for external fact store " + i);
				}
			}
			
			if (fullClassName==null) 
				throw new CompilerException();
			
			out.print("public static ");
			out.print(fullClassName);
			out.print(" ");
			out.print(fs.getId());
			out.println("=null;");
		}
		
		out.println("}");
	}
	
	/**
	 * Create the kb class.
	 * @param out the writer
	 * @param clazz the class name
	 * @param pck the package name
	 */
	private void createKBClass(PrintWriter out, String clazz, String pck)
			throws CompilerException {
		out.print("package ");
		out.print(pck);
		out.println(";");
		out.println("import nz.org.take.rt.*;");
		
		// print additional imports
		printImports(out);
		
		out.println("/**");
		out.println(" * Class generated by the take compiler. ");
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");
		out.println("@SuppressWarnings(\"unchecked\")");
		out.print("public class ");
		out.print(clazz);
		
		if (this.interfaceNames!=null && this.interfaceNames.length>0) {
			out.print(" implements ");
			printCommaSeparatedList(out,this.interfaceNames);
		}
		out.println("{");

		while (!this.isAgendaEmpty()) {
			createMethod(out, pck+'.'+clazz,this.getNextQuery());
		}

		out.println("}");
	}

	/**
	 * Create a class that can be used to keep track of variable bindings in rules.
	 * @param out the writer
	 * @param r  the rule
	 * @return a map associating variables with instance variable names
	 */
	private Map<Term, String> createBindingClass(PrintWriter out, DerivationRule r) throws CompilerException {
		Map<Term, String> map = new HashMap<Term, String>();
		this.printOneLineComment(out, "Variable bindings in rule: ", r);
		String name = this.getBindingClassName(r);
		out.print("class ");
		out.print(name);
		out.println('{');
		int counter = 1;
		List<Term> termsInRule = this.getAllTerms(r);		
		for (Term t : termsInRule) {
			if (!map.containsKey(t)) {
					String property = "p" + counter;
					counter = counter + 1;
					map.put(t, property);
					this.printOneLineComment(out,	"Property generated for term  \"", t,"\"");
					out.print(t.getType().getName());
					out.print(" ");
					out.print(property);
					out.println(";");
				}
			} 

		out.println("};");
		return map;
	}

	/**
	 * Create a class for a return type. 
	 * @param out  the writer
	 * @param clazz   the class name
	 * @param pck the package name
	 * @param p  the predicate
	 */
	private void createReturnType(PrintWriter out, String clazz, String pck,Predicate p) throws CompilerException {
		Slot[] slots = buildSlots(p);
		out.print("package ");
		out.print(pck);
		out.println(";");

		out.println("/**");
		out.println(" * Class generated by the take compiler. ");
		out.println(" * This class represents the predicate " + p.getName());
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");

		out.print("public class ");
		out.print(clazz);
		out.println("{");

		// constructor with parameters
		out.print("public ");
		out.print(clazz);
		out.print('(');
		boolean first = true;
		for (Slot slot : slots) {
			if (first)
				first = false;
			else
				out.print(',');
			out.print(slot.type);
			out.print(" ");
			out.print(slot.var);
		}
		out.println("){");
		out.println("super();");
		for (Slot slot : slots) {
			this.printVariableAssignment(out, "this", slot.var, slot.var, null);
		}
		out.println("}");

		// constructor withour params
		out.print("public ");
		out.print(clazz);
		out.print("(){");
		out.println("super();");
		out.println("}");

		// fields
		for (Slot slot : slots) {
			printVariableDeclaration(out, "public", slot.type, slot.var);
		}
		
		out.println("}");
	}
	/**
	 * Create an interface for an external fact store. 
	 * @param out  the writer
	 * @param clazz the interface name
	 * @param pck the package name
	 * @param fs the fact store
	 */
	private void createExternalFactStoreType(PrintWriter out, String clazz, String pck,ExternalFactStore fs) throws CompilerException {
		Predicate p = fs.getPredicate();
		
		Slot[] slots = buildSlots(p);
		out.print("package ");
		out.print(pck);
		out.println(";");
		
		out.println("/**");
		out.println(" * Class generated by the take compiler. ");
		out.print(" * This class represents the external fact store ");
		out.println(fs.getId());
		out.print(" * for the predicate ");
		out.println(p.getName());
		out.print(" * @version ");
		out.println(new Date());
		out.println(" */");

		out.print("public interface ");
		out.print(clazz);
		out.println("{");
		
		out.println(" // Get all instances of this type from the fact store. ");
		out.print("public nz.org.take.rt.ResourceIterator<");
		out.print(packageName );
		out.print(".");
		out.print(getClassName(p));
		out.print("> fetch(");
		boolean f = true;
		for (Slot slot : slots) {
			if (f)
				f = false;
			else
				out.print(',');
			out.print(slot.type);
			out.print(" ");
			out.print(slot.var);
		}
		out.println(");");
		
		out.println("}");
	}
	
	/**
	 * Create a private method for the given query.
	 * @param out
	 * @param className the class owning the method
	 * @param q
	 * @throws CompilerException
	 */
	@SuppressWarnings("unchecked")
	private void createMethod(PrintWriter out, String className, Query q)	throws CompilerException {
		if (mustCreatePublicMethod(q))
			createPublicMethod(out,q,true);
		createPrivateMethod(out,className,q);
	}
	/**
	 * Define for which predicates (queries) not to define a public method. 
	 * E.g., not public methods are generated for numerical comparisons. 
	 * @param q
	 * @return
	 */
	protected boolean mustCreatePublicMethod(Query q) {
		Predicate p = q.getPredicate();
		return !(p instanceof Comparison);
	} 
	
	/**
	 * Create a public method for the given query.
	 * @param out
	 * @param q
	 * @param includeBody
	 * @throws CompilerException
	 */
	@SuppressWarnings("unchecked")
	private void createPublicMethod(PrintWriter out, Query q,boolean includeBody)
			throws CompilerException {
		Slot[] inSlots = this.buildInputSlots(q);
		Predicate p = q.getPredicate();

		printMethodComment(out, "Method generated for query " + q, inSlots,
				"an iterator for instances of " + getClassName(p));

		// start header
		this.printGenericType(out, "public ResultSet", getClassName(p));
		String methodName = getMethodName(q);
		out.print(methodName);

		printParameters(out, inSlots, true,false,false);
		// end params
		if (includeBody) {
			out.println("{");
			out.print("DerivationController ");
			out.print(this.getVarName4DerivationController());
			out.print(" = new ");
			out.print(this.getDerivationControllerClass());
			out.print('(');
			boolean first = false;
			for (String param:this.getDerivationControllerInitialisationParameters()) {
				if (first)
					first = false;
				else
					out.print(',');
				out.print(param);
			}			
			out.println(");");
			
			//	call the private method
			this.printGenericType(out, "ResultSet", getClassName(p));
			out.print("_result = new ResultSet(");
			out.print(methodName); 
			printParameters(out, inSlots, false,true,false); 
			out.println(',');
			out.println(this.getVarName4DerivationController());
			out.println(");");
			out.println("return _result;} ");
		}
		else 
			out.println(";");  // abstract method
	}
	

	/**
	 * Create a private method for the given query.
	 * @param out
	 * @param className the class name
	 * @param q
	 * @throws CompilerException
	 */
	@SuppressWarnings("unchecked")
	private void createPrivateMethod(PrintWriter out, String className, Query q) 	throws CompilerException {
		Predicate p = q.getPredicate();
		String methodName = null; 
		if (p instanceof SimplePredicate) {
			methodName = createPrivateMethod1(out,q);
		}
		else {
			// try to use plugin
			for (CompilerPlugin plugin:this.plugins) {
				if (plugin.supports(q)) {
					// the next line may throw an exception
					// an alternative strategy would be "try next plugin"
					
					//plugin.checkPrerequisites(q);
					methodName = plugin.createMethod(out, q);
				}
			}
		}
		if (methodName!=null) {
			this.endorseMethod(className,methodName);
			this.removeFromAgenda();
		}		
		else throw new CompilerException("This combination of predicate type and parameter signature is not supported in queries: " + p.getClass() + q.getIOSignatureAsString());
	}
	/**
	 * Create a private method for the given query.
	 * The predicate of the query is defined by rules and facts.
	 * @param out
	 * @param q
	 * @return the method name
	 * @throws CompilerException
	 */
	private String createPrivateMethod1(PrintWriter out, Query q) 	throws CompilerException {
		Slot[] inSlots = this.buildInputSlots(q);
		Slot[] outSlots = this.buildOutputSlots(q);
		Predicate p = q.getPredicate();

		printMethodComment(out, "Method generated for query " + q, inSlots,"an iterator for instances of " + getClassName(p));

		// start header
		this.printGenericType(out, "private ResourceIterator", getClassName(p));
		String methodName = getMethodName(q);
		out.print(methodName);

		printParameters(out, inSlots, true,true,false);
		// end params
		out.println("{");
		
		// variable to cache derivation depth
		out.print("final int _derivationlevel=");
		out.print(this.getVarName4DerivationController());
		out.println(".getDepth();");
		
		List<KnowledgeElement> css = kb.getElements(p);

		out.print("ResourceIterator<");
		out.print(getClassName(p));
		out.print("> ");
		out.print(RESULT);
		out.print("= new ");
		out.print("IteratorChain<");
		out.print(getClassName(p));
		out.print(">(");
		out.print(css.size());
		out.println("){");

		out.print("public Object getIteratorOrObject(int pos){");
		out.println("switch(pos){");
		for (int i = 0; i < css.size(); i++) {
			out.print("// ");
			out.println(css.get(i));
			out.print("case ");
			out.print(i);
			out.print(":");
			out.print("return ");
			out.print(getMethodName(q, i));
			printParameters(out, inSlots, false,true,true);
			out.println(';');
		}

		out.println("default:");
		out.println("return EmptyIterator.DEFAULT;");
		out.println("} // switch(pos)");
		out.println("} // getIterator()");
		
		out.print("public String getRuleRef(int pos){");
		out.println("switch(pos){");
		for (int i = 0; i < css.size(); i++) {
			out.print("// ");
			out.println(css.get(i));
			out.print("case ");
			out.print(i);
			out.print(":");
			out.print("return \"");
			out.print(getRuleRef(css.get(i)));
			out.println("\";");
		}

		out.println("default:");
		out.println("return \"\";");
		out.println("} // switch(pos)");
		out.println("} // getRuleRef()");
		out.println("};"); // end inner class
		out.print("return "); // end inner class
		out.println(RESULT);
		out.println(";}");
		
		// generate a method for each clause set
		for (int i = 0; i < css.size(); i++) {
			createMethod(out, q, inSlots, outSlots, css.get(i), i);
		}
		
		return methodName;

	}

	// create private method
	private void createMethod(PrintWriter out, Query q, Slot[] islots,Slot[] oslots, KnowledgeElement cs, int i) throws CompilerException {
		Predicate p = q.getPredicate();
		printMethodComment(out, "Method generated for query " + q, islots,
				"an iterator for instances of " + getClassName(p));

		// facts are handled differently to minimize memory consumption
		if (cs instanceof Fact) {
			out.print("private ");
			out.print(getClassName(q.getPredicate()));
			out.print(' ');
		}
		else {
			out.print("private ResourceIterator<");
			out.print(getClassName(q.getPredicate()));
			out.print("> ");
		}
		
		
		out.print(getMethodName(q, i));
		printParameters(out, islots, true,true,false);
		out.print("{");

		// generate method body
		if (cs instanceof Fact) {
			createBody(out, q, islots, oslots, (Fact) cs);
		} 
		else if (cs instanceof ExternalFactStore){
			createBody(out, q, islots, oslots, (ExternalFactStore) cs);
		}
		else if (cs instanceof DerivationRule) {
			createBody(out, q, islots, oslots, (DerivationRule) cs);
		} else {
			out.print("// this clause set type is not yet supported: ");
			out.println(cs.getClass());

		}

		out.println("}");
	}
	/**
	 * Create a proof for a query.
	 * 
	 * @param out -
	 *            a print writer
	 * @param q -
	 *            the query
	 * @param islots -
	 *            the input slots (known)
	 * @param oslots -
	 *            the output slots (to be bound)
	 * @param f -
	 *            the fact
	 * @throws CompilerException
	 */
	private void createBody(PrintWriter out, Query q, Slot[] islots,
			Slot[] oslots, Fact f) throws CompilerException {
		
		// log 
		printLogStatement(out,f,q.getInputParams(),islots);
		
		// start creating return var
		Predicate p = q.getPredicate();
		out.print(getClassName(p));
		out.print(" ");
		out.print(RESULT);
		out.print("=");
		printContructorInvocation(out, getClassName(p), null);
		out.println(";");

		// start initializing return var
		for (Slot slot : islots) {
			out.print(RESULT);
			out.print(".");
			out.print(slot.var);
			out.print("=");
			out.print(slot.var);
			out.println(";");
		}

		if (islots.length == 0)
			out.println("if (true) {");
		else {
			out.print("if (");
			boolean first = true;
			for (Slot slot : islots) {
				if (first)
					first = false;
				else
					out.print("&&");
				out.print(slot.var);
				out.print(".equals(");
				Term t = f.getTerms()[slot.position];
				assert (t instanceof Constant);
				out.print(getRef(this.getNameGenerator().getConstantRegistryClassName(),(Constant)t));
				out.print(")");
			}
			out.println("){");
		}

		for (Slot slot : oslots) {
			out.print(RESULT);
			out.print(".");
			out.print(slot.var);
			out.print("=");
			Term t = f.getTerms()[slot.position];
			assert (t instanceof Constant);
			out.print(getRef(this.getNameGenerator().getConstantRegistryClassName(),(Constant) t));
			out.println(";");
		}
		out.print("return ");
		out.print(RESULT);
		out.println(';');
		out.println("}");
		out.print("return null;");

	}

	/**
	 * Create a proof for a query.
	 * @param out a print writer
	 * @param q the query
	 * @param islots the input slots (known)
	 * @param oslots the output slots (to be bound)
	 * @param fs the fact store
	 * @throws CompilerException
	 */
	private void createBody(PrintWriter out, Query q, Slot[] islots,
			Slot[] oslots, ExternalFactStore fs) throws CompilerException {
		
		String regClass = this.getNameGenerator().getFactStoreRegistryClassName();
		
		String factStoreRef = regClass +'.'+fs.getId();
		// print log statement
		printLogStatement(out,fs,q.getInputParams(),islots);
		
		
		// invoke external fact set
		out.print("return ");
		out.print(factStoreRef);
		out.print('.');
		out.print("fetch");
		out.print('(');
		// parameter list
		boolean f = true;
		for (int i=0;i<fs.getPredicate().getSlotTypes().length;i++) {
			if (f)
				f = false;
			else 
				out.print(',');
			// see whether we can use a parameter, iotherwise use null
			String param = "null";
			for (int j=0;j<islots.length;j++) {
				if (i==j) {
					param = islots[j].name;
					break;
				}					
			}
			out.print(param);
			
		}
		
		
		out.print(");");

	}

	/**
	 * Create a proof for a query.
	 * @param out a print writer
	 * @param q the query
	 * @param islots the input slots (known)
	 * @param oslots the output slots (to be bound)
	 * @param r the rule
	 * @throws CompilerException
	 */
	private void createBody(PrintWriter out, Query q, Slot[] islots,Slot[] oslots, DerivationRule r) throws CompilerException {
		
		// print log statement
		printLogStatement(out,r,q.getInputParams(),islots);
		
		// the concrete bindings for this rule
		List<Term> allTerms = this.getAllTerms(r);
		Bindings bindings = new Bindings(allTerms);
		
		// compute initial bindings
		Fact head = r.getHead();
		Term[] terms = head.getTerms();
		
		// bind all inputslots to variables of the current rule
		for (int i = 0; i < islots.length; i++) {
			bindings.put(terms[islots[i].position], islots[i].var);
		}
		// bind all constant terms
		for (Term t:terms) {
			if (t instanceof Constant) {
				bindings.put(t,getRef(this.getNameGenerator().getConstantRegistryClassName(),(Constant)t));
			}
		}

		String bindingsClass = this.getBindingClassName(r);
		// all variable names of the current rule
		Map<Term, String> refs = createBindingClass(out, r);
		out.print("final ");
		out.print(bindingsClass);
		out.print(" ");
		out.print("bindings");
		out.print(" = ");
		this.printContructorInvocation(out, bindingsClass, null);
		out.println(';');

		// assign input vars
		for (Map.Entry<Term, String> refEntry : refs.entrySet()) {
			String var = bindings.getRef(refEntry.getKey());
			if (var != null) {				
				printVariableAssignment(out, "bindings",refEntry.getValue(),var);
			}
		}

		List<Fact> literals = new ArrayList<Fact>();
		Fact previousFact = null;
		literals.addAll(r.getBody());
		literals.add(r.getHead());
		TmpVarGenerator varGen = new TmpVarGenerator();
		String iteratorName = null, className = null, previousIteratorName = null, previousClassName = null;
		boolean first = true;
		int counter = 1;
		for (Fact prereq : literals) {
			iteratorName = varGen.nextTmpVar("iterator");
			className = getClassName(prereq);
			this.printOneLineComment(out, "code for prereq ", prereq);
			out.print("final ");
			this.printGenericType(out, "ResourceIterator", className);

			out.print(iteratorName);
			out.print(" = ");
			
			// add constants to bindings
			// bind all constant terms
			for (Term t:prereq.getTerms()) {
				if (t instanceof Constant) {
					bindings.put(t,getRef(this.getNameGenerator().getConstantRegistryClassName(),(Constant)t));
				}
			}

			/*
			 * if (prereq!=r.getHead()) addToAgenda(query);
			 */
			if (first) {
				// call method
				// unification: find the input params known
				QueryRef query = buildQuery(prereq, bindings);
				first = false;
				printInvocation(out, query,true,true);
				counter = counter+1;
				out.println(";");
				if (prereq != r.getHead()) {
					addToAgenda(query);
				}
			} else {
				printContructorInvocation2(out, "NestedIterator",
						previousClassName, className, previousIteratorName);
				out.println("{");
				out.print("public ResourceIterator<");
				out.print(className);
				out.print("> getNextIterator(");
				out.print(previousClassName);
				out.print(" object");
				out.println("){");
				// bind params from previous iterator
				// here we set the attributes of the bindings object
				Term[] pterms = previousFact.getTerms();
				for (int i = 0; i < pterms.length; i++) {
					Term t = pterms[i];
					Slot slot = this.buildSlot(previousFact.getPredicate(),	i);
					
					// the type of the term and the type of the predicate slot might be different (but compatible - the term types must be a subtype
					// of the slot type. If they are different, a cast must be generated
					
					Class termType = t.getType();
					Class slotType = previousFact.getPredicate().getSlotTypes()[i];
					String cast = termType.equals(slotType)?null:termType.getName();
					String ref = refs.get(t);
					if (t instanceof Variable) {
						Variable vt = (Variable) t;						
						printVariableAssignment(out, "bindings",ref,"object", slot.var,cast);
						bindings.put(vt, refs.get(vt));
					} else if (t instanceof ComplexTerm) {
						ComplexTerm vt = (ComplexTerm) t;						
						printVariableAssignment(out, "bindings",ref,"object", slot.var,cast);
						bindings.put(vt, refs.get(vt));						
					} else if (t instanceof Constant) {
						Constant vt = (Constant) t;						
						printVariableAssignment(out, "bindings",ref,getRef(this.getNameGenerator().getConstantRegistryClassName(),vt),null,cast);
						bindings.put(vt, refs.get(vt));						
					}
					else {
						// REFACTOR generalise - cover constant terms
						throw new CompilerException("Only variables are supported here");
					}
				}
				// build method call
				// here we call the method that supplies the next iterator
				boolean[] sig = new boolean[prereq.getPredicate()	.getSlotTypes().length];
				List<String> params = new ArrayList<String>(sig.length);
				for (int j = 0; j < sig.length; j++) {
					// bind known variables
					// OLD TODO remove comments
					// problem
					//String expr = refs.get(prereq.getTerms()[j]);
					// terms  that have been bound
					sig[j] = bindings.hasBinding(prereq.getTerms()[j]);
					if (sig[j]) {
						params	.add("bindings."+refs.get(prereq.getTerms()[j]));
					}
				}
				// TODO
				QueryRef nextQuery = new QueryRef(prereq.getPredicate(), sig,	params);
				this.configNewQuery(nextQuery);
				
				out.print("return ");
				if (prereq == r.getHead()) {
					out.print("new SingletonIterator(");
					printConstructorInvocation(out, nextQuery);
					out.println(")");
				} else {
					addToAgenda(nextQuery);
					// the method that must be called
					printInvocation(out, nextQuery,true,true);
					counter = counter+1;
				}
				out.println(";");
				out.println("}");

				out.println("};");
			}
			previousIteratorName = iteratorName;
			previousClassName = className;
			previousFact = prereq;
		}
		out.print("return ");
		out.print(iteratorName);
		out.println(";");
	}
   /**
	 * Indicates whether the publicAgenda is empty.
	 * 
	 * @return Returns a boolean.
	 */
	private boolean isAgendaEmpty() {
		return publicAgenda.isEmpty();
	}

	/**
	 * Returns the next query.
	 * 
	 * @return a query
	 */
	private Query getNextQuery() {
		return publicAgenda.get(0);
	}

	/**
	 * Remove the current query.
	 * 
	 * @return a query
	 */
	private void removeFromAgenda() {
		Query q = publicAgenda.remove(0);
		done.add(q);
	}

	/**
	 * Add a query to the publicAgenda.
	 * 
	 * @param q
	 *            a query
	 */
	private void addToAgenda(Query q) {
		if (!done.contains(q) && !publicAgenda.contains(q)) {
			publicAgenda.add(q);
			if (getLogger().isDebugEnabled()) {
				getLogger().debug("Adding query to agenda: " + q);
			}
		}
	}

	/**
	 * Get the name generator.
	 * 
	 * @return Returns the nameGenerator.
	 */
	public NameGenerator getNameGenerator() {
		return nameGenerator;
	}

	/**
	 * Set the name generator.
	 * 
	 * @param nameGenerator
	 *            The nameGenerator to set.
	 */
	public void setNameGenerator(NameGenerator nameGenerator) {
		this.nameGenerator = nameGenerator;
	}

	/**
	 * Get the class name for the bindings used in the method generated for a
	 * rule. 
	 * @param r a rule
	 * @return a string
	 */
	private String getBindingClassName(DerivationRule r) {
		String name = bindingClassNames.get(r);
		if (name == null) {
			name = "bindingsInRule" + this.bindingClassCounter;
			bindingClassNames.put(r, name);
			bindingClassCounter = bindingClassCounter + 1;
		}
		return name;
	}

	/**
	 * Add a source code transformer.
	 * @param t
	 */
	public void add(SourceTransformation t) {
		this.transformations.add(t);
	}
	
	/**
	 * Print the import stattements.
	 * @param out a print writer
	 */
	private void printImports(PrintWriter out) {
		if (this.importStatements!=null) {
			for (String s:this.importStatements) {
				out.print("import ");
				out.print(s);
				out.println(";");
			}
		}
	}

	/**
	 * Remove a source code transformer.
	 * @param t
	 */
	public void remove(SourceTransformation t) {
		this.transformations.remove(t);
	}

	/**
	 * Get a list of source transformers installed.
	 * @return a list of transformations
	 */
	public List<SourceTransformation> getSourceTransformers() {
		return this.transformations;
	}

	public String getDerivationControllerClass() {
		return derivationControllerClass;
	}

	public void setDerivationControllerClass(String derivationControllerClass) {
		this.derivationControllerClass = derivationControllerClass;
	}

	public String[] getDerivationControllerInitialisationParameters() {
		return derivationControllerInitialisationParameters;
	}

	public void setDerivationControllerInitialisationParameters(
			String[] derivationControllerInitialisationParameters) {
		this.derivationControllerInitialisationParameters = derivationControllerInitialisationParameters;
	}

	public String getVarName4DerivationController() {
		return varName4DerivationController;
	}

	public void setVarName4DerivationController(String varName4DerivationController) {
		this.varName4DerivationController = varName4DerivationController;
	}


	
	public Map<String, String> getMethodNames4QueriesFromAnnotations() {
		return methodNames4QueriesFromAnnotations;
	}

	@Override
	public KnowledgeBase getKB() {
		return kb;
	}
	/**
	 * Install a plugin.
	 * @param plugin a new compiler plugin
	 */
	public void install(CompilerPlugin plugin) {
		this.plugins.add(plugin);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String[] getInterfaceNames() {
		return interfaceNames;
	}

	public void setInterfaceNames(String...  interfaceNames) {
		this.interfaceNames = interfaceNames;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isGenerateDataClassesForQueryPredicates() {
		return generateDataClassesForQueryPredicates;
	}

	public void setGenerateDataClassesForQueryPredicates(
			boolean generateDataClassesForQueryPredicates) {
		this.generateDataClassesForQueryPredicates = generateDataClassesForQueryPredicates;
	}
	private  Set<Predicate> getPublicPredicates() {
		if (this.publicPredicates==null) {
			publicPredicates = new HashSet<Predicate>();
			for (Query q:this.kb.getQueries()) {
				publicPredicates.add(q.getPredicate());
			}
		}
		return publicPredicates;
	}
	
	private  Map<String,ExternalFactStore> getExternalFactStores() {
		if (this.externalFactStores==null) {
			externalFactStores = new HashMap<String,ExternalFactStore>();
			for (KnowledgeElement e:kb.getElements()) {
				if (e instanceof ExternalFactStore) {
					ExternalFactStore fs = (ExternalFactStore)e;
					externalFactStores.put(fs.getId(),fs);
				}
			}
		}
		return externalFactStores;
	}
	

	public String[] getImportStatements() {
		return importStatements;
	}

	public void setImportStatements(String... importStatements) {
		this.importStatements = importStatements;
	}
	private String getExternalDataStoreName(ExternalFactStore ds) {
		boolean exclusive = true;
		String id = ds.getId();
		Predicate p = ds.getPredicate();
		for (Map.Entry<String,ExternalFactStore> e:this.getExternalFactStores().entrySet()){
			if (id!=e.getKey() && p.equals(e.getValue())) {
				exclusive = false;
				break;
			}
				
		}
		String pClassName = "ExternalFactStore4"+getClassName(ds.getPredicate());
		if (!exclusive) {
			pClassName = pClassName + '_' + id;
		}
		return pClassName;
	}
}
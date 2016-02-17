# Example #

The code for this example is in the [repository](http://take.googlecode.com/svn/trunk/take/src/example/nz/org/take/compiler/example1/). The [script](http://take.googlecode.com/svn/trunk/take/src/example/nz/org/take/compiler/example1/crm-example.take) contains only one rule:

```
rule1: if equals(category(customer),goldCustomer) then discount(customer,goldCustomerDiscount) 
```

The utility `GenerateInterface` is used to generate a [public interface](http://take.googlecode.com/svn/trunk/take/src/example/nz/org/take/compiler/example1/spec/) for this script. In particular, the class `DiscountPolicy` with the method `getDiscount(Customer)` is generated.

The `Example` script then does the following:
  1. reads the script from the rule
  1. compiles the (rule) into Java sources
  1. compiles the sources using the Java compiler API
  1. binds the object references in the script
  1. loads the generated class
  1. queries the class for the discount for a given customer
  1. prints the results and lists the rules used

Note that this mechanism works very much like JavaServerPages (JSPs)! The working directory containing the generated sources and compiled classes is in `/takeWorkingDir`.

```
	// prepare
	DiscountPolicy KB = null; // this is the generated interface
	BasicConfigurator.configure();

	// compile and bind constants referenced in rules
	KnowledgeBaseManager<DiscountPolicy> kbm = new KnowledgeBaseManager<DiscountPolicy>();
	Bindings bindings = new SimpleBindings();		
	bindings.put("goldCustomer",new CustomerCategory("gold"));
	bindings.put("goldCustomerDiscount",new Discount(20,true));
	KB = kbm.getKnowledgeBase(
	   DiscountPolicy.class, 
	   new ScriptKnowledgeSource("exampledata/example1/crm-example.take"),
	   bindings);
		
	// now use the generated classes to query the kb
	Customer john = new Customer("John");
	john.setCategory(new CustomerCategory("gold"));
	ResultSet<CustomerDiscount> result =  KB.getDiscount(john);
	System.out.println("The discount for John is: " + result.next().discount);
	    
	// print rules used
	System.out.println("The following rules have been used to calculate the discount: ");
	for (DerivationLogEntry e:result.getDerivationLog()) {
	        System.out.print(e.getCategory());
	    	System.out.print(" : ");
	    	System.out.println(e.getName());
	}
	    
```
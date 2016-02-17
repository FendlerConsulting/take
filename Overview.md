# Take Overview #

Take is a (derivation) rule compiler and scripting engine for Java.
Take consists of the following 4 parts:
  1. the take knowledge base API for derivation rules that is very similar to [mandarax](http://www.mandarax.org)
  1. a simple scripting language for derivation rules that supports annotations
  1. a compiler that can generate executable code from take knowledge bases
  1. an interface to [R2ML](http://en.wikipedia.org/wiki/R2ML) that can be used to generate code from (modified) UML models that use derivation rules in order to define the semantics of derived associations and properties

The main motivation for starting Take was:
  1. to take advantage of the new Java Compiler and Scripting API
  1. to address some scalability problems Mandarax has (Mandarax uses an interpreter, but the overall ideas are very similar)
  1. to generate non trivial code from advanced (UML) models - could be seen as contribution to the MDA vision

Design Goals:
  1. treat rules like server pages - generate code, compile and load at runtime
  1. easy integration of external knowledge (web services, relational databases, ..)
  1. simple API based on POJOs and iterators
  1. applications have access to derivation trace (rules and facts that have been used to compute a result)
  1. direct support Java features like methods (as predicates and functions), properties and associations
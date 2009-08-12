// $ANTLR 3.1.1 /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g 2009-08-11 18:06:24

package nz.org.take.script.antlr;

import java.util.Collection;
import java.util.List;

import nz.org.take.Aggregations;
import nz.org.take.AggregationFunction;
import nz.org.take.Annotatable;
import nz.org.take.Clause;
import nz.org.take.ComplexTerm;
import nz.org.take.Constant;
import nz.org.take.DefaultKnowledgeBase;
import nz.org.take.DerivationRule;
import nz.org.take.ExpressionException;
import nz.org.take.ExpressionPrerequisite;
import nz.org.take.ExternalFactStore;
import nz.org.take.Fact;
import nz.org.take.KnowledgeBase;
import nz.org.take.Predicate;
import nz.org.take.PredicatePrerequisite;
import nz.org.take.Prerequisite;
import nz.org.take.Query;
import nz.org.take.Term;
import nz.org.take.Variable;
import nz.org.take.script.DuplicateSymbolException;
import nz.org.take.script.IOState;
import nz.org.take.script.NamedElementTable;
import nz.org.take.script.NoSuchPredicateException;
import nz.org.take.script.QueryBuilder;
import nz.org.take.script.QueryDeclaration;
import nz.org.take.script.TakeGrammarException;
import nz.org.take.script.TermList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/** 
 * A Take grammar for ANTLRv3. 
 */
public class TakeParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GlobalAnnotationKey", "LocalAnnotationKey", "AnnotationValue", "Identifier", "Newline", "Expression", "HexLiteral", "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "Exponent", "FloatTypeSuffix", "EscapeSequence", "UnicodeEscape", "OctalEscape", "GlobalAnnotation", "LocalAnnotation", "Whitespace", "Letter", "IDDigit", "BlockComment", "LineComment", "'var'", "','", "'ref'", "'aggregation'", "'='", "'avg'", "'min'", "'max'", "'sum'", "'count'", "'query'", "'|'", "'in'", "'out'", "'external'", "':'", "'if'", "'then'", "'and'", "'not'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'"
    };
    public static final int T__29=29;
    public static final int FloatTypeSuffix=18;
    public static final int OctalLiteral=12;
    public static final int LineComment=28;
    public static final int Exponent=17;
    public static final int Newline=8;
    public static final int AnnotationValue=6;
    public static final int EOF=-1;
    public static final int HexDigit=15;
    public static final int Identifier=7;
    public static final int BlockComment=27;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int LocalAnnotationKey=5;
    public static final int IDDigit=26;
    public static final int Whitespace=24;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int HexLiteral=10;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int IntegerTypeSuffix=16;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int DecimalLiteral=11;
    public static final int Expression=9;
    public static final int StringLiteral=14;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int LocalAnnotation=23;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int GlobalAnnotationKey=4;
    public static final int T__39=39;
    public static final int UnicodeEscape=20;
    public static final int FloatingPointLiteral=13;
    public static final int GlobalAnnotation=22;
    public static final int Letter=25;
    public static final int OctalEscape=21;
    public static final int EscapeSequence=19;

    // delegates
    // delegators


        public TakeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TakeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[67+1];
             
             
        }
        

    public String[] getTokenNames() { return TakeParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g"; }


    private KnowledgeBase knowledgeBase = new DefaultKnowledgeBase();

    private NamedElementTable<AggregationFunction> aggregationTable = new NamedElementTable<AggregationFunction>();
    private NamedElementTable<Constant> constantTable = new NamedElementTable<Constant>();
    private NamedElementTable<Clause> clauseTable = new NamedElementTable<Clause>();
    private NamedElementTable<Predicate> predicateTable = new NamedElementTable<Predicate>();
    private NamedElementTable<Variable> variableTable = new NamedElementTable<Variable>();
    private NamedElementTable<QueryDeclaration> queryTable = new NamedElementTable<QueryDeclaration>();

    private void annotate(Collection<? extends Annotatable> annotatables) {
        for (Annotatable annotatable : annotatables)
            annotate(annotatable);
    }

    private void annotate(Annotatable annotatable) {
        annotatable.addAnnotations(getGlobalAnnotations());
        annotatable.addAnnotations(getLocalAnnotations());
    }

    private Map<String, String> getGlobalAnnotations() {
        return knowledgeBase.getAnnotations();
    }

    private Map<String, String> getLocalAnnotations() {
        return ((declaration_scope)declaration_stack.peek()).annotations;
    }

    private boolean isValidPrerequisiteExpression(String expression) {
        try {
            createExpressionPrerequisite(expression);
            return true;
        } catch (TakeGrammarException e) {
            return false;
        }
    }

    private ExpressionPrerequisite createExpressionPrerequisite(String expression) throws TakeGrammarException {
        try {
        	return new ExpressionPrerequisite(expression, getActiveExpressionLanguage(), getDeclaredElementTypeMap());
        } catch (ExpressionException e) {
            throw new TakeGrammarException(e);
        }
    }

    private boolean isValidComplexTermExpression(String expression) {
        try {
            createComplexTerm(expression);
            return true;
        } catch (TakeGrammarException e) {
            return false;
        }
    }

    private ComplexTerm createComplexTerm(String expression) throws TakeGrammarException {
        try {
        	return new ComplexTerm(expression, getActiveExpressionLanguage(), getDeclaredElementTypeMap());
        } catch (ExpressionException e) {
            throw new TakeGrammarException(e);
        }
    }

    private String getActiveExpressionLanguage() {
        return "nz.org.take.mvel2.MVEL2ExpressionLanguage";
    }

    private Map<String, Class<?>> getDeclaredElementTypeMap() {
        Map<String, Class<?>> typeMap = new HashMap<String, Class<?>>();
        
        for (Variable variable : variableTable.getValues()) {
            typeMap.put(variable.getName(), variable.getType());
        }
        
        for (Constant constant : constantTable.getValues()) {
            typeMap.put(constant.getName(), constant.getType());
        }
        
        return typeMap;
    }

    private AggregationFunction createAggregationFunction(String name, Aggregations aggregation, Variable variable, Fact query) throws TakeGrammarException {
        AggregationFunction function = new AggregationFunction();
        function.setName(name);
        function.setAggregation(aggregation);
        function.setVariable(variable);
        function.setQuery(query);
        
        try {
            aggregationTable.put(function);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return function;
    }

    private Fact createFact(String name, Predicate predicate, TermList terms) throws TakeGrammarException {
        Fact fact = createAnonymousFact(predicate, terms);
        fact.setId(name);
        
        try {
            clauseTable.put(fact);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return fact;
    }

    private Fact createAnonymousFact(Predicate predicate, TermList terms) {
        Fact fact = new Fact();
        fact.setPredicate(predicate);
        fact.setTerms(terms.toArray());
        
        return fact;
    }

    private DerivationRule createRule(String name, List<Prerequisite> body, Fact head) throws TakeGrammarException {
        DerivationRule rule = new DerivationRule();
        rule.setId(name);
        rule.setBody(body);
        rule.setHead(head);
        
        try {
            clauseTable.put(rule);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return rule;
    }

    private Predicate createPredicate(String name, TermList params) throws TakeGrammarException {
        Predicate predicate = new Predicate();
        predicate.setName(name);
        predicate.setSlotTypes(params.getArrayOfTypes());
        
        try {
            predicateTable.put(predicate);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
         
        return predicate;
    }

    private Constant createConstant(String name, Class<?> type) throws TakeGrammarException {
        checkElementNameIsUnique(name);
        
        Constant constant = new Constant();
        constant.setRef(name);
        constant.setType(type);
        
        try {
            constantTable.put(constant);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return constant;
    }

    private Variable createVariable(String name, Class<?> type) throws TakeGrammarException {
        checkElementNameIsUnique(name);
        
        Variable variable = new Variable();
        variable.setName(name);
        variable.setType(type);
        
        try {
            variableTable.put(variable);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return variable;
    }

    private void checkElementNameIsUnique(String name) throws TakeGrammarException {
        if (variableTable.containsName(name) || constantTable.containsName(name)) {
            throw new TakeGrammarException(new DuplicateSymbolException(name));
        }
    }

    private boolean isValidClass(String className) {
        try {
            createClass(className);
            return true;
        } catch (TakeGrammarException e) {
            return false;
        }
    }

    private Class<?> createClass(String className) throws TakeGrammarException {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new TakeGrammarException(e);
        }
    }

    private QueryDeclaration createQueryDeclaration(Token predicate, List<IOState> parameterStates) throws TakeGrammarException {
        QueryDeclaration query = new QueryDeclaration(predicate, parameterStates);
        
        try {
            queryTable.put(query);
        } catch (DuplicateSymbolException e) {
            throw new TakeGrammarException(e);
        }
        
        return query;
    }

    private void buildQueries() throws TakeGrammarException {
        QueryBuilder queryBuilder = new QueryBuilder(predicateTable);
        Iterable<Query> queries = null;
        
        try {
            queries = queryBuilder.buildQueries(queryTable.getValues());
        } catch (NoSuchPredicateException e) {
            throw new TakeGrammarException(e);
        }
        
        for (Query query : queries)
            knowledgeBase.add(query);  
    }

    private void importClausesIntoKnowledgeBase() {
        for (Clause clause : clauseTable.getValues())
            knowledgeBase.add(clause);
    }




    // $ANTLR start "script"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:314:1: script returns [KnowledgeBase knowledgeBase] : ( globalAnnotation | declaration )* ;
    public final KnowledgeBase script() throws RecognitionException {
        KnowledgeBase knowledgeBase = null;
        int script_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return knowledgeBase; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:321:5: ( ( globalAnnotation | declaration )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:321:9: ( globalAnnotation | declaration )*
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:321:9: ( globalAnnotation | declaration )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==GlobalAnnotationKey) ) {
                    alt1=1;
                }
                else if ( (LA1_0==LocalAnnotationKey||LA1_0==Identifier||LA1_0==29||(LA1_0>=31 && LA1_0<=32)||LA1_0==39||LA1_0==43) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:321:13: globalAnnotation
            	    {
            	    pushFollow(FOLLOW_globalAnnotation_in_script97);
            	    globalAnnotation();

            	    state._fsp--;
            	    if (state.failed) return knowledgeBase;

            	    }
            	    break;
            	case 2 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:322:13: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_script111);
            	    declaration();

            	    state._fsp--;
            	    if (state.failed) return knowledgeBase;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

                  buildQueries();
                  importClausesIntoKnowledgeBase();
                  
                  knowledgeBase = this.knowledgeBase;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, script_StartIndex); }
        }
        return knowledgeBase;
    }
    // $ANTLR end "script"

    protected static class declaration_scope {
        Map<String, String> annotations;
    }
    protected Stack declaration_stack = new Stack();


    // $ANTLR start "declaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:326:1: declaration : ( localAnnotation )* ( variableDeclarations | constantDeclarations | aggregationDeclaration | queryDeclaration | factStoreDeclaration | factDeclaration | ruleDeclaration ) ;
    public final void declaration() throws RecognitionException {
        declaration_stack.push(new declaration_scope());
        int declaration_StartIndex = input.index();
        Collection<Variable> variableDeclarations1 = null;

        Collection<Constant> constantDeclarations2 = null;

        QueryDeclaration queryDeclaration3 = null;

        ExternalFactStore factStoreDeclaration4 = null;

        Fact factDeclaration5 = null;

        DerivationRule ruleDeclaration6 = null;


         ((declaration_scope)declaration_stack.peek()).annotations = new HashMap<String, String>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:329:5: ( ( localAnnotation )* ( variableDeclarations | constantDeclarations | aggregationDeclaration | queryDeclaration | factStoreDeclaration | factDeclaration | ruleDeclaration ) )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:329:9: ( localAnnotation )* ( variableDeclarations | constantDeclarations | aggregationDeclaration | queryDeclaration | factStoreDeclaration | factDeclaration | ruleDeclaration )
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:329:9: ( localAnnotation )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==LocalAnnotationKey) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:0:0: localAnnotation
            	    {
            	    pushFollow(FOLLOW_localAnnotation_in_declaration150);
            	    localAnnotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:330:9: ( variableDeclarations | constantDeclarations | aggregationDeclaration | queryDeclaration | factStoreDeclaration | factDeclaration | ruleDeclaration )
            int alt3=7;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:330:13: variableDeclarations
                    {
                    pushFollow(FOLLOW_variableDeclarations_in_declaration165);
                    variableDeclarations1=variableDeclarations();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(variableDeclarations1); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:331:13: constantDeclarations
                    {
                    pushFollow(FOLLOW_constantDeclarations_in_declaration184);
                    constantDeclarations2=constantDeclarations();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(constantDeclarations2); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:332:13: aggregationDeclaration
                    {
                    pushFollow(FOLLOW_aggregationDeclaration_in_declaration203);
                    aggregationDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:333:13: queryDeclaration
                    {
                    pushFollow(FOLLOW_queryDeclaration_in_declaration217);
                    queryDeclaration3=queryDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(queryDeclaration3); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:334:13: factStoreDeclaration
                    {
                    pushFollow(FOLLOW_factStoreDeclaration_in_declaration240);
                    factStoreDeclaration4=factStoreDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(factStoreDeclaration4); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:335:13: factDeclaration
                    {
                    pushFollow(FOLLOW_factDeclaration_in_declaration259);
                    factDeclaration5=factDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(factDeclaration5); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:336:13: ruleDeclaration
                    {
                    pushFollow(FOLLOW_ruleDeclaration_in_declaration283);
                    ruleDeclaration6=ruleDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       annotate(ruleDeclaration6); 
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, declaration_StartIndex); }
            declaration_stack.pop();
        }
        return ;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "globalAnnotation"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:340:1: globalAnnotation : GlobalAnnotationKey AnnotationValue ;
    public final void globalAnnotation() throws RecognitionException {
        int globalAnnotation_StartIndex = input.index();
        Token GlobalAnnotationKey7=null;
        Token AnnotationValue8=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:341:5: ( GlobalAnnotationKey AnnotationValue )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:341:9: GlobalAnnotationKey AnnotationValue
            {
            GlobalAnnotationKey7=(Token)match(input,GlobalAnnotationKey,FOLLOW_GlobalAnnotationKey_in_globalAnnotation322); if (state.failed) return ;
            AnnotationValue8=(Token)match(input,AnnotationValue,FOLLOW_AnnotationValue_in_globalAnnotation324); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               knowledgeBase.addAnnotation((GlobalAnnotationKey7!=null?GlobalAnnotationKey7.getText():null), (AnnotationValue8!=null?AnnotationValue8.getText():null)); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, globalAnnotation_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "globalAnnotation"


    // $ANTLR start "localAnnotation"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:344:1: localAnnotation : LocalAnnotationKey AnnotationValue ;
    public final void localAnnotation() throws RecognitionException {
        int localAnnotation_StartIndex = input.index();
        Token LocalAnnotationKey9=null;
        Token AnnotationValue10=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:345:5: ( LocalAnnotationKey AnnotationValue )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:345:9: LocalAnnotationKey AnnotationValue
            {
            LocalAnnotationKey9=(Token)match(input,LocalAnnotationKey,FOLLOW_LocalAnnotationKey_in_localAnnotation345); if (state.failed) return ;
            AnnotationValue10=(Token)match(input,AnnotationValue,FOLLOW_AnnotationValue_in_localAnnotation347); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               ((declaration_scope)declaration_stack.peek()).annotations.put((LocalAnnotationKey9!=null?LocalAnnotationKey9.getText():null), (AnnotationValue10!=null?AnnotationValue10.getText():null)); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, localAnnotation_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "localAnnotation"


    // $ANTLR start "variableDeclarations"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:348:1: variableDeclarations returns [Collection<Variable> values] : 'var' type ids+= Identifier ( ',' ids+= Identifier )* Newline ;
    public final Collection<Variable> variableDeclarations() throws RecognitionException {
        Collection<Variable> values = null;
        int variableDeclarations_StartIndex = input.index();
        Token ids=null;
        List list_ids=null;
        Class<?> type11 = null;


         values = new ArrayList<Variable>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return values; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:350:5: ( 'var' type ids+= Identifier ( ',' ids+= Identifier )* Newline )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:350:9: 'var' type ids+= Identifier ( ',' ids+= Identifier )* Newline
            {
            match(input,29,FOLLOW_29_in_variableDeclarations377); if (state.failed) return values;
            pushFollow(FOLLOW_type_in_variableDeclarations379);
            type11=type();

            state._fsp--;
            if (state.failed) return values;
            ids=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclarations383); if (state.failed) return values;
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:350:36: ( ',' ids+= Identifier )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==30) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:350:37: ',' ids+= Identifier
            	    {
            	    match(input,30,FOLLOW_30_in_variableDeclarations386); if (state.failed) return values;
            	    ids=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclarations390); if (state.failed) return values;
            	    if (list_ids==null) list_ids=new ArrayList();
            	    list_ids.add(ids);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,Newline,FOLLOW_Newline_in_variableDeclarations394); if (state.failed) return values;
            if ( state.backtracking==0 ) {

                          for (Token id : (List<Token>)list_ids) {
                          	Variable variable = createVariable(id.getText(), type11);
                          	values.add(variable);
                          }
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, variableDeclarations_StartIndex); }
        }
        return values;
    }
    // $ANTLR end "variableDeclarations"


    // $ANTLR start "constantDeclarations"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:359:1: constantDeclarations returns [Collection<Constant> values] : 'ref' type ids+= Identifier ( ',' ids+= Identifier )* Newline ;
    public final Collection<Constant> constantDeclarations() throws RecognitionException {
        Collection<Constant> values = null;
        int constantDeclarations_StartIndex = input.index();
        Token ids=null;
        List list_ids=null;
        Class<?> type12 = null;


         values = new ArrayList<Constant>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return values; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:361:5: ( 'ref' type ids+= Identifier ( ',' ids+= Identifier )* Newline )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:361:9: 'ref' type ids+= Identifier ( ',' ids+= Identifier )* Newline
            {
            match(input,31,FOLLOW_31_in_constantDeclarations432); if (state.failed) return values;
            pushFollow(FOLLOW_type_in_constantDeclarations434);
            type12=type();

            state._fsp--;
            if (state.failed) return values;
            ids=(Token)match(input,Identifier,FOLLOW_Identifier_in_constantDeclarations438); if (state.failed) return values;
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:361:36: ( ',' ids+= Identifier )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==30) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:361:37: ',' ids+= Identifier
            	    {
            	    match(input,30,FOLLOW_30_in_constantDeclarations441); if (state.failed) return values;
            	    ids=(Token)match(input,Identifier,FOLLOW_Identifier_in_constantDeclarations445); if (state.failed) return values;
            	    if (list_ids==null) list_ids=new ArrayList();
            	    list_ids.add(ids);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,Newline,FOLLOW_Newline_in_constantDeclarations449); if (state.failed) return values;
            if ( state.backtracking==0 ) {

                          for (Token id : (List<Token>)list_ids) {
                              Constant constant = createConstant(id.getText(), type12);
                              values.add(constant);
                          }
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, constantDeclarations_StartIndex); }
        }
        return values;
    }
    // $ANTLR end "constantDeclarations"


    // $ANTLR start "aggregationDeclaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:370:1: aggregationDeclaration returns [AggregationFunction value] : 'aggregation' Identifier '=' aggregateFunction variable predicate Newline ;
    public final AggregationFunction aggregationDeclaration() throws RecognitionException {
        AggregationFunction value = null;
        int aggregationDeclaration_StartIndex = input.index();
        Token Identifier14=null;
        TakeParser.predicate_return predicate13 = null;

        Aggregations aggregateFunction15 = null;

        Variable variable16 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:371:5: ( 'aggregation' Identifier '=' aggregateFunction variable predicate Newline )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:371:9: 'aggregation' Identifier '=' aggregateFunction variable predicate Newline
            {
            match(input,32,FOLLOW_32_in_aggregationDeclaration486); if (state.failed) return value;
            Identifier14=(Token)match(input,Identifier,FOLLOW_Identifier_in_aggregationDeclaration488); if (state.failed) return value;
            match(input,33,FOLLOW_33_in_aggregationDeclaration490); if (state.failed) return value;
            pushFollow(FOLLOW_aggregateFunction_in_aggregationDeclaration492);
            aggregateFunction15=aggregateFunction();

            state._fsp--;
            if (state.failed) return value;
            pushFollow(FOLLOW_variable_in_aggregationDeclaration494);
            variable16=variable();

            state._fsp--;
            if (state.failed) return value;
            pushFollow(FOLLOW_predicate_in_aggregationDeclaration496);
            predicate13=predicate();

            state._fsp--;
            if (state.failed) return value;
            match(input,Newline,FOLLOW_Newline_in_aggregationDeclaration498); if (state.failed) return value;
            if ( state.backtracking==0 ) {

                          Fact query = createAnonymousFact((predicate13!=null?predicate13.value:null), (predicate13!=null?predicate13.terms:null));
                          value = createAggregationFunction((Identifier14!=null?Identifier14.getText():null), aggregateFunction15, variable16, query);
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, aggregationDeclaration_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "aggregationDeclaration"


    // $ANTLR start "aggregateFunction"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:378:1: aggregateFunction returns [Aggregations value] : ( 'avg' | 'min' | 'max' | 'sum' | 'count' );
    public final Aggregations aggregateFunction() throws RecognitionException {
        Aggregations value = null;
        int aggregateFunction_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:379:5: ( 'avg' | 'min' | 'max' | 'sum' | 'count' )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt6=1;
                }
                break;
            case 35:
                {
                alt6=2;
                }
                break;
            case 36:
                {
                alt6=3;
                }
                break;
            case 37:
                {
                alt6=4;
                }
                break;
            case 38:
                {
                alt6=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:379:9: 'avg'
                    {
                    match(input,34,FOLLOW_34_in_aggregateFunction531); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Aggregations.AVG; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:380:9: 'min'
                    {
                    match(input,35,FOLLOW_35_in_aggregateFunction545); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Aggregations.MIN; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:381:9: 'max'
                    {
                    match(input,36,FOLLOW_36_in_aggregateFunction559); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Aggregations.MAX; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:382:9: 'sum'
                    {
                    match(input,37,FOLLOW_37_in_aggregateFunction573); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Aggregations.SUM; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:383:9: 'count'
                    {
                    match(input,38,FOLLOW_38_in_aggregateFunction587); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Aggregations.COUNT; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, aggregateFunction_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "aggregateFunction"


    // $ANTLR start "variable"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:386:1: variable returns [Variable value] : variableName= Identifier {...}?;
    public final Variable variable() throws RecognitionException {
        Variable value = null;
        int variable_StartIndex = input.index();
        Token variableName=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:387:5: (variableName= Identifier {...}?)
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:387:9: variableName= Identifier {...}?
            {
            variableName=(Token)match(input,Identifier,FOLLOW_Identifier_in_variable614); if (state.failed) return value;
            if ( !(( variableTable.containsName((variableName!=null?variableName.getText():null)) )) ) {
                if (state.backtracking>0) {state.failed=true; return value;}
                throw new FailedPredicateException(input, "variable", " variableTable.containsName($variableName.text) ");
            }
            if ( state.backtracking==0 ) {
               value = variableTable.get((variableName!=null?variableName.getText():null)); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, variable_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "variable"


    // $ANTLR start "queryDeclaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:390:1: queryDeclaration returns [QueryDeclaration value] : 'query' queryName= Identifier '|' ioStates '|' ;
    public final QueryDeclaration queryDeclaration() throws RecognitionException {
        QueryDeclaration value = null;
        int queryDeclaration_StartIndex = input.index();
        Token queryName=null;
        List<IOState> ioStates17 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:391:5: ( 'query' queryName= Identifier '|' ioStates '|' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:391:9: 'query' queryName= Identifier '|' ioStates '|'
            {
            match(input,39,FOLLOW_39_in_queryDeclaration641); if (state.failed) return value;
            queryName=(Token)match(input,Identifier,FOLLOW_Identifier_in_queryDeclaration645); if (state.failed) return value;
            match(input,40,FOLLOW_40_in_queryDeclaration647); if (state.failed) return value;
            pushFollow(FOLLOW_ioStates_in_queryDeclaration649);
            ioStates17=ioStates();

            state._fsp--;
            if (state.failed) return value;
            match(input,40,FOLLOW_40_in_queryDeclaration651); if (state.failed) return value;
            if ( state.backtracking==0 ) {

                          value = createQueryDeclaration(queryName, ioStates17);
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, queryDeclaration_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "queryDeclaration"


    // $ANTLR start "ioStates"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:397:1: ioStates returns [List<IOState> values] : firstState= ioState ( ',' extraState= ioState )* ;
    public final List<IOState> ioStates() throws RecognitionException {
        List<IOState> values = null;
        int ioStates_StartIndex = input.index();
        IOState firstState = null;

        IOState extraState = null;


         values = new ArrayList<IOState>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return values; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:399:5: (firstState= ioState ( ',' extraState= ioState )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:399:9: firstState= ioState ( ',' extraState= ioState )*
            {
            pushFollow(FOLLOW_ioState_in_ioStates691);
            firstState=ioState();

            state._fsp--;
            if (state.failed) return values;
            if ( state.backtracking==0 ) {
               values.add(firstState); 
            }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:399:64: ( ',' extraState= ioState )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==30) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:399:65: ',' extraState= ioState
            	    {
            	    match(input,30,FOLLOW_30_in_ioStates696); if (state.failed) return values;
            	    pushFollow(FOLLOW_ioState_in_ioStates700);
            	    extraState=ioState();

            	    state._fsp--;
            	    if (state.failed) return values;
            	    if ( state.backtracking==0 ) {
            	       values.add(extraState); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, ioStates_StartIndex); }
        }
        return values;
    }
    // $ANTLR end "ioStates"


    // $ANTLR start "ioState"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:402:1: ioState returns [IOState value] : ( 'in' | 'out' );
    public final IOState ioState() throws RecognitionException {
        IOState value = null;
        int ioState_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:403:5: ( 'in' | 'out' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==41) ) {
                alt8=1;
            }
            else if ( (LA8_0==42) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:403:7: 'in'
                    {
                    match(input,41,FOLLOW_41_in_ioState726); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = IOState.IN; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:404:9: 'out'
                    {
                    match(input,42,FOLLOW_42_in_ioState740); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = IOState.OUT; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, ioState_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "ioState"


    // $ANTLR start "factStoreDeclaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:407:1: factStoreDeclaration returns [ExternalFactStore value] : 'external' ;
    public final ExternalFactStore factStoreDeclaration() throws RecognitionException {
        ExternalFactStore value = null;
        int factStoreDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:408:5: ( 'external' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:408:9: 'external'
            {
            match(input,43,FOLLOW_43_in_factStoreDeclaration766); if (state.failed) return value;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, factStoreDeclaration_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "factStoreDeclaration"


    // $ANTLR start "factDeclaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:411:1: factDeclaration returns [Fact value] : factName= Identifier ':' predicate ;
    public final Fact factDeclaration() throws RecognitionException {
        Fact value = null;
        int factDeclaration_StartIndex = input.index();
        Token factName=null;
        TakeParser.predicate_return predicate18 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:412:5: (factName= Identifier ':' predicate )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:412:9: factName= Identifier ':' predicate
            {
            factName=(Token)match(input,Identifier,FOLLOW_Identifier_in_factDeclaration791); if (state.failed) return value;
            match(input,44,FOLLOW_44_in_factDeclaration793); if (state.failed) return value;
            pushFollow(FOLLOW_predicate_in_factDeclaration795);
            predicate18=predicate();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {

                          value = createFact((factName!=null?factName.getText():null), (predicate18!=null?predicate18.value:null), (predicate18!=null?predicate18.terms:null));
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, factDeclaration_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "factDeclaration"


    // $ANTLR start "ruleDeclaration"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:418:1: ruleDeclaration returns [DerivationRule value] : ruleName= Identifier ':' 'if' body= prerequisites 'then' predicate ;
    public final DerivationRule ruleDeclaration() throws RecognitionException {
        DerivationRule value = null;
        int ruleDeclaration_StartIndex = input.index();
        Token ruleName=null;
        List<Prerequisite> body = null;

        TakeParser.predicate_return predicate19 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:419:5: (ruleName= Identifier ':' 'if' body= prerequisites 'then' predicate )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:419:9: ruleName= Identifier ':' 'if' body= prerequisites 'then' predicate
            {
            ruleName=(Token)match(input,Identifier,FOLLOW_Identifier_in_ruleDeclaration830); if (state.failed) return value;
            match(input,44,FOLLOW_44_in_ruleDeclaration832); if (state.failed) return value;
            match(input,45,FOLLOW_45_in_ruleDeclaration834); if (state.failed) return value;
            pushFollow(FOLLOW_prerequisites_in_ruleDeclaration838);
            body=prerequisites();

            state._fsp--;
            if (state.failed) return value;
            match(input,46,FOLLOW_46_in_ruleDeclaration840); if (state.failed) return value;
            pushFollow(FOLLOW_predicate_in_ruleDeclaration842);
            predicate19=predicate();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {

                          Fact head = createAnonymousFact((predicate19!=null?predicate19.value:null), (predicate19!=null?predicate19.terms:null));
                          value = createRule((ruleName!=null?ruleName.getText():null), body, head);
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, ruleDeclaration_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "prerequisites"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:426:1: prerequisites returns [List<Prerequisite> values] : firstPrerequisite= prerequisite ( 'and' extraPrerequisite= prerequisite )* ;
    public final List<Prerequisite> prerequisites() throws RecognitionException {
        List<Prerequisite> values = null;
        int prerequisites_StartIndex = input.index();
        Prerequisite firstPrerequisite = null;

        Prerequisite extraPrerequisite = null;


         values = new ArrayList<Prerequisite>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return values; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:428:5: (firstPrerequisite= prerequisite ( 'and' extraPrerequisite= prerequisite )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:428:9: firstPrerequisite= prerequisite ( 'and' extraPrerequisite= prerequisite )*
            {
            pushFollow(FOLLOW_prerequisite_in_prerequisites886);
            firstPrerequisite=prerequisite();

            state._fsp--;
            if (state.failed) return values;
            if ( state.backtracking==0 ) {
               values.add(firstPrerequisite); 
            }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:428:83: ( 'and' extraPrerequisite= prerequisite )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==47) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:428:84: 'and' extraPrerequisite= prerequisite
            	    {
            	    match(input,47,FOLLOW_47_in_prerequisites891); if (state.failed) return values;
            	    pushFollow(FOLLOW_prerequisite_in_prerequisites895);
            	    extraPrerequisite=prerequisite();

            	    state._fsp--;
            	    if (state.failed) return values;
            	    if ( state.backtracking==0 ) {
            	       values.add(extraPrerequisite); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, prerequisites_StartIndex); }
        }
        return values;
    }
    // $ANTLR end "prerequisites"


    // $ANTLR start "prerequisite"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:431:1: prerequisite returns [Prerequisite value] : ( predicatePrerequisite | expressionPrerequisite );
    public final Prerequisite prerequisite() throws RecognitionException {
        Prerequisite value = null;
        int prerequisite_StartIndex = input.index();
        PredicatePrerequisite predicatePrerequisite20 = null;

        ExpressionPrerequisite expressionPrerequisite21 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:432:5: ( predicatePrerequisite | expressionPrerequisite )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier||LA10_0==48) ) {
                alt10=1;
            }
            else if ( (LA10_0==Expression) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:432:9: predicatePrerequisite
                    {
                    pushFollow(FOLLOW_predicatePrerequisite_in_prerequisite922);
                    predicatePrerequisite20=predicatePrerequisite();

                    state._fsp--;
                    if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = predicatePrerequisite20; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:433:9: expressionPrerequisite
                    {
                    pushFollow(FOLLOW_expressionPrerequisite_in_prerequisite934);
                    expressionPrerequisite21=expressionPrerequisite();

                    state._fsp--;
                    if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = expressionPrerequisite21; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, prerequisite_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "prerequisite"


    // $ANTLR start "predicatePrerequisite"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:436:1: predicatePrerequisite returns [PredicatePrerequisite value] : negatablePredicate ;
    public final PredicatePrerequisite predicatePrerequisite() throws RecognitionException {
        PredicatePrerequisite value = null;
        int predicatePrerequisite_StartIndex = input.index();
        TakeParser.negatablePredicate_return negatablePredicate22 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:437:5: ( negatablePredicate )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:437:9: negatablePredicate
            {
            pushFollow(FOLLOW_negatablePredicate_in_predicatePrerequisite959);
            negatablePredicate22=negatablePredicate();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
               value = new PredicatePrerequisite((negatablePredicate22!=null?negatablePredicate22.value:null)); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, predicatePrerequisite_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "predicatePrerequisite"


    // $ANTLR start "expressionPrerequisite"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:440:1: expressionPrerequisite returns [ExpressionPrerequisite value] : Expression {...}?;
    public final ExpressionPrerequisite expressionPrerequisite() throws RecognitionException {
        ExpressionPrerequisite value = null;
        int expressionPrerequisite_StartIndex = input.index();
        Token Expression23=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:441:5: ( Expression {...}?)
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:441:9: Expression {...}?
            {
            Expression23=(Token)match(input,Expression,FOLLOW_Expression_in_expressionPrerequisite984); if (state.failed) return value;
            if ( !(( isValidPrerequisiteExpression((Expression23!=null?Expression23.getText():null)) )) ) {
                if (state.backtracking>0) {state.failed=true; return value;}
                throw new FailedPredicateException(input, "expressionPrerequisite", " isValidPrerequisiteExpression($Expression.text) ");
            }
            if ( state.backtracking==0 ) {

                          value = createExpressionPrerequisite((Expression23!=null?Expression23.getText():null));
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, expressionPrerequisite_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "expressionPrerequisite"

    public static class negatablePredicate_return extends ParserRuleReturnScope {
        public Predicate value;
        public TermList terms;
    };

    // $ANTLR start "negatablePredicate"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:447:1: negatablePredicate returns [Predicate value, TermList terms] : ( 'not' predicate | predicate );
    public final TakeParser.negatablePredicate_return negatablePredicate() throws RecognitionException {
        TakeParser.negatablePredicate_return retval = new TakeParser.negatablePredicate_return();
        retval.start = input.LT(1);
        int negatablePredicate_StartIndex = input.index();
        TakeParser.predicate_return predicate24 = null;

        TakeParser.predicate_return predicate25 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:448:2: ( 'not' predicate | predicate )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==48) ) {
                alt11=1;
            }
            else if ( (LA11_0==Identifier) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:448:6: 'not' predicate
                    {
                    match(input,48,FOLLOW_48_in_negatablePredicate1016); if (state.failed) return retval;
                    pushFollow(FOLLOW_predicate_in_negatablePredicate1018);
                    predicate24=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       (predicate24!=null?predicate24.value:null).setNegated(true); retval.value = (predicate24!=null?predicate24.value:null); retval.terms = (predicate24!=null?predicate24.terms:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:449:6: predicate
                    {
                    pushFollow(FOLLOW_predicate_in_negatablePredicate1027);
                    predicate25=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.value = (predicate25!=null?predicate25.value:null); retval.terms = (predicate25!=null?predicate25.terms:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, negatablePredicate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "negatablePredicate"

    public static class predicate_return extends ParserRuleReturnScope {
        public Predicate value;
        public TermList terms;
    };

    // $ANTLR start "predicate"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:452:1: predicate returns [Predicate value, TermList terms] : ( existingPredicate | newPredicate );
    public final TakeParser.predicate_return predicate() throws RecognitionException {
        TakeParser.predicate_return retval = new TakeParser.predicate_return();
        retval.start = input.LT(1);
        int predicate_StartIndex = input.index();
        TakeParser.existingPredicate_return existingPredicate26 = null;

        TakeParser.newPredicate_return newPredicate27 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:453:5: ( existingPredicate | newPredicate )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:453:9: existingPredicate
                    {
                    pushFollow(FOLLOW_existingPredicate_in_predicate1055);
                    existingPredicate26=existingPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.value = (existingPredicate26!=null?existingPredicate26.value:null); retval.terms = (existingPredicate26!=null?existingPredicate26.terms:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:454:9: newPredicate
                    {
                    pushFollow(FOLLOW_newPredicate_in_predicate1068);
                    newPredicate27=newPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.value = (newPredicate27!=null?newPredicate27.value:null); retval.terms = (newPredicate27!=null?newPredicate27.terms:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, predicate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class existingPredicate_return extends ParserRuleReturnScope {
        public Predicate value;
        public TermList terms;
    };

    // $ANTLR start "existingPredicate"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:457:1: existingPredicate returns [Predicate value, TermList terms] : predicateName= Identifier '|' params= terms '|' {...}?;
    public final TakeParser.existingPredicate_return existingPredicate() throws RecognitionException {
        TakeParser.existingPredicate_return retval = new TakeParser.existingPredicate_return();
        retval.start = input.LT(1);
        int existingPredicate_StartIndex = input.index();
        Token predicateName=null;
        TermList params = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:458:2: (predicateName= Identifier '|' params= terms '|' {...}?)
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:458:6: predicateName= Identifier '|' params= terms '|' {...}?
            {
            predicateName=(Token)match(input,Identifier,FOLLOW_Identifier_in_existingPredicate1103); if (state.failed) return retval;
            match(input,40,FOLLOW_40_in_existingPredicate1105); if (state.failed) return retval;
            pushFollow(FOLLOW_terms_in_existingPredicate1109);
            params=terms();

            state._fsp--;
            if (state.failed) return retval;
            match(input,40,FOLLOW_40_in_existingPredicate1111); if (state.failed) return retval;
            if ( !(( predicateTable.containsName((predicateName!=null?predicateName.getText():null)) )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "existingPredicate", " predicateTable.containsName($predicateName.text) ");
            }
            if ( state.backtracking==0 ) {

              	        retval.value = predicateTable.get((predicateName!=null?predicateName.getText():null));
              	        retval.terms = params;
              	    
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, existingPredicate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "existingPredicate"

    public static class newPredicate_return extends ParserRuleReturnScope {
        public Predicate value;
        public TermList terms;
    };

    // $ANTLR start "newPredicate"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:465:1: newPredicate returns [Predicate value, TermList terms] : predicateName= Identifier '|' params= terms '|' ;
    public final TakeParser.newPredicate_return newPredicate() throws RecognitionException {
        TakeParser.newPredicate_return retval = new TakeParser.newPredicate_return();
        retval.start = input.LT(1);
        int newPredicate_StartIndex = input.index();
        Token predicateName=null;
        TermList params = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:466:5: (predicateName= Identifier '|' params= terms '|' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:466:9: predicateName= Identifier '|' params= terms '|'
            {
            predicateName=(Token)match(input,Identifier,FOLLOW_Identifier_in_newPredicate1143); if (state.failed) return retval;
            match(input,40,FOLLOW_40_in_newPredicate1145); if (state.failed) return retval;
            pushFollow(FOLLOW_terms_in_newPredicate1149);
            params=terms();

            state._fsp--;
            if (state.failed) return retval;
            match(input,40,FOLLOW_40_in_newPredicate1151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                          retval.value = createPredicate((predicateName!=null?predicateName.getText():null), params);
                          retval.terms = params;
                      
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, newPredicate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "newPredicate"


    // $ANTLR start "terms"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:473:1: terms returns [TermList values] : firstTerm= term ( ',' extraTerm= term )* ;
    public final TermList terms() throws RecognitionException {
        TermList values = null;
        int terms_StartIndex = input.index();
        Term firstTerm = null;

        Term extraTerm = null;


         values = new TermList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return values; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:475:5: (firstTerm= term ( ',' extraTerm= term )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:475:9: firstTerm= term ( ',' extraTerm= term )*
            {
            pushFollow(FOLLOW_term_in_terms1191);
            firstTerm=term();

            state._fsp--;
            if (state.failed) return values;
            if ( state.backtracking==0 ) {
               values.add(firstTerm); 
            }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:475:59: ( ',' extraTerm= term )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:475:60: ',' extraTerm= term
            	    {
            	    match(input,30,FOLLOW_30_in_terms1196); if (state.failed) return values;
            	    pushFollow(FOLLOW_term_in_terms1200);
            	    extraTerm=term();

            	    state._fsp--;
            	    if (state.failed) return values;
            	    if ( state.backtracking==0 ) {
            	       values.add(extraTerm); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, terms_StartIndex); }
        }
        return values;
    }
    // $ANTLR end "terms"


    // $ANTLR start "term"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:478:1: term returns [Term value] : complexTerm ;
    public final Term term() throws RecognitionException {
        Term value = null;
        int term_StartIndex = input.index();
        ComplexTerm complexTerm28 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:479:5: ( complexTerm )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:479:9: complexTerm
            {
            pushFollow(FOLLOW_complexTerm_in_term1231);
            complexTerm28=complexTerm();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
               value = complexTerm28; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, term_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "term"


    // $ANTLR start "complexTerm"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:482:1: complexTerm returns [ComplexTerm value] : t= ( Expression | Identifier | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | StringLiteral ) {...}?;
    public final ComplexTerm complexTerm() throws RecognitionException {
        ComplexTerm value = null;
        int complexTerm_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:483:5: (t= ( Expression | Identifier | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | StringLiteral ) {...}?)
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:483:9: t= ( Expression | Identifier | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | StringLiteral ) {...}?
            {
            t=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||(input.LA(1)>=Expression && input.LA(1)<=StringLiteral) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( !(( isValidComplexTermExpression((t!=null?t.getText():null)) )) ) {
                if (state.backtracking>0) {state.failed=true; return value;}
                throw new FailedPredicateException(input, "complexTerm", " isValidComplexTermExpression($t.text) ");
            }
            if ( state.backtracking==0 ) {

                      	value = createComplexTerm((t!=null?t.getText():null));
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, complexTerm_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "complexTerm"


    // $ANTLR start "type"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:490:1: type returns [Class<?> value] : ( classOrInterfaceType | primitiveType );
    public final Class<?> type() throws RecognitionException {
        Class<?> value = null;
        int type_StartIndex = input.index();
        Class<?> classOrInterfaceType29 = null;

        Class<?> primitiveType30 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:491:5: ( classOrInterfaceType | primitiveType )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Identifier) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=50 && LA14_0<=57)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:491:9: classOrInterfaceType
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_type1332);
                    classOrInterfaceType29=classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = classOrInterfaceType29; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:492:9: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_type1345);
                    primitiveType30=primitiveType();

                    state._fsp--;
                    if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = primitiveType30; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, type_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "type"


    // $ANTLR start "classOrInterfaceType"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:495:1: classOrInterfaceType returns [Class<?> value] : qualifiedName {...}?;
    public final Class<?> classOrInterfaceType() throws RecognitionException {
        Class<?> value = null;
        int classOrInterfaceType_StartIndex = input.index();
        TakeParser.qualifiedName_return qualifiedName31 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:496:5: ( qualifiedName {...}?)
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:496:9: qualifiedName {...}?
            {
            pushFollow(FOLLOW_qualifiedName_in_classOrInterfaceType1378);
            qualifiedName31=qualifiedName();

            state._fsp--;
            if (state.failed) return value;
            if ( !(( isValidClass((qualifiedName31!=null?input.toString(qualifiedName31.start,qualifiedName31.stop):null)) )) ) {
                if (state.backtracking>0) {state.failed=true; return value;}
                throw new FailedPredicateException(input, "classOrInterfaceType", " isValidClass($qualifiedName.text) ");
            }
            if ( state.backtracking==0 ) {

                          value = createClass((qualifiedName31!=null?input.toString(qualifiedName31.start,qualifiedName31.stop):null));
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, classOrInterfaceType_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "classOrInterfaceType"

    public static class qualifiedName_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "qualifiedName"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:502:1: qualifiedName : Identifier ( '.' Identifier )* ;
    public final TakeParser.qualifiedName_return qualifiedName() throws RecognitionException {
        TakeParser.qualifiedName_return retval = new TakeParser.qualifiedName_return();
        retval.start = input.LT(1);
        int qualifiedName_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:503:5: ( Identifier ( '.' Identifier )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:503:9: Identifier ( '.' Identifier )*
            {
            match(input,Identifier,FOLLOW_Identifier_in_qualifiedName1409); if (state.failed) return retval;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:503:20: ( '.' Identifier )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==49) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:503:21: '.' Identifier
            	    {
            	    match(input,49,FOLLOW_49_in_qualifiedName1412); if (state.failed) return retval;
            	    match(input,Identifier,FOLLOW_Identifier_in_qualifiedName1414); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, qualifiedName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedName"


    // $ANTLR start "primitiveType"
    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:506:1: primitiveType returns [Class<?> value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final Class<?> primitiveType() throws RecognitionException {
        Class<?> value = null;
        int primitiveType_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return value; }
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:507:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt16=8;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt16=1;
                }
                break;
            case 51:
                {
                alt16=2;
                }
                break;
            case 52:
                {
                alt16=3;
                }
                break;
            case 53:
                {
                alt16=4;
                }
                break;
            case 54:
                {
                alt16=5;
                }
                break;
            case 55:
                {
                alt16=6;
                }
                break;
            case 56:
                {
                alt16=7;
                }
                break;
            case 57:
                {
                alt16=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:507:9: 'boolean'
                    {
                    match(input,50,FOLLOW_50_in_primitiveType1439); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Boolean.TYPE; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:508:9: 'char'
                    {
                    match(input,51,FOLLOW_51_in_primitiveType1452); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Character.TYPE; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:509:9: 'byte'
                    {
                    match(input,52,FOLLOW_52_in_primitiveType1468); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Byte.TYPE; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:510:9: 'short'
                    {
                    match(input,53,FOLLOW_53_in_primitiveType1484); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Short.TYPE; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:511:9: 'int'
                    {
                    match(input,54,FOLLOW_54_in_primitiveType1499); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Integer.TYPE; 
                    }

                    }
                    break;
                case 6 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:512:9: 'long'
                    {
                    match(input,55,FOLLOW_55_in_primitiveType1516); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Long.TYPE; 
                    }

                    }
                    break;
                case 7 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:513:9: 'float'
                    {
                    match(input,56,FOLLOW_56_in_primitiveType1532); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Float.TYPE; 
                    }

                    }
                    break;
                case 8 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:514:9: 'double'
                    {
                    match(input,57,FOLLOW_57_in_primitiveType1547); if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                       value = Double.TYPE; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, primitiveType_StartIndex); }
        }
        return value;
    }
    // $ANTLR end "primitiveType"

    // $ANTLR start synpred21_Take
    public final void synpred21_Take_fragment() throws RecognitionException {   
        // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:453:9: ( existingPredicate )
        // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:453:9: existingPredicate
        {
        pushFollow(FOLLOW_existingPredicate_in_synpred21_Take1055);
        existingPredicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_Take

    // Delegated rules

    public final boolean synpred21_Take() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Take_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\12\uffff";
    static final String DFA3_minS =
        "\1\7\5\uffff\1\54\1\7\2\uffff";
    static final String DFA3_maxS =
        "\1\53\5\uffff\1\54\1\55\2\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\7\1\6";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\25\uffff\1\1\1\uffff\1\2\1\3\6\uffff\1\4\3\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\11\45\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "330:9: ( variableDeclarations | constantDeclarations | aggregationDeclaration | queryDeclaration | factStoreDeclaration | factDeclaration | ruleDeclaration )";
        }
    }
    static final String DFA12_eotS =
        "\11\uffff";
    static final String DFA12_eofS =
        "\11\uffff";
    static final String DFA12_minS =
        "\1\7\1\50\1\7\1\36\1\7\1\0\1\36\2\uffff";
    static final String DFA12_maxS =
        "\1\7\1\50\1\16\1\50\1\16\1\0\1\50\2\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\1\1\2";
    static final String DFA12_specialS =
        "\5\uffff\1\0\3\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\uffff\6\3",
            "\1\4\11\uffff\1\5",
            "\1\6\1\uffff\6\6",
            "\1\uffff",
            "\1\4\11\uffff\1\5",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "452:1: predicate returns [Predicate value, TermList terms] : ( existingPredicate | newPredicate );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Take()) ) {s = 7;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index12_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_globalAnnotation_in_script97 = new BitSet(new long[]{0x00000881A00000B2L});
    public static final BitSet FOLLOW_declaration_in_script111 = new BitSet(new long[]{0x00000881A00000B2L});
    public static final BitSet FOLLOW_localAnnotation_in_declaration150 = new BitSet(new long[]{0x00000881A00000B0L});
    public static final BitSet FOLLOW_variableDeclarations_in_declaration165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantDeclarations_in_declaration184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aggregationDeclaration_in_declaration203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_queryDeclaration_in_declaration217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factStoreDeclaration_in_declaration240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factDeclaration_in_declaration259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_declaration283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GlobalAnnotationKey_in_globalAnnotation322 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AnnotationValue_in_globalAnnotation324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LocalAnnotationKey_in_localAnnotation345 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AnnotationValue_in_localAnnotation347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_variableDeclarations377 = new BitSet(new long[]{0x03FC000000000080L});
    public static final BitSet FOLLOW_type_in_variableDeclarations379 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclarations383 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_30_in_variableDeclarations386 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclarations390 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_Newline_in_variableDeclarations394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_constantDeclarations432 = new BitSet(new long[]{0x03FC000000000080L});
    public static final BitSet FOLLOW_type_in_constantDeclarations434 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_constantDeclarations438 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_30_in_constantDeclarations441 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_constantDeclarations445 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_Newline_in_constantDeclarations449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_aggregationDeclaration486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_aggregationDeclaration488 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_aggregationDeclaration490 = new BitSet(new long[]{0x0000007C00000000L});
    public static final BitSet FOLLOW_aggregateFunction_in_aggregationDeclaration492 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_variable_in_aggregationDeclaration494 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_predicate_in_aggregationDeclaration496 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Newline_in_aggregationDeclaration498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_aggregateFunction531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_aggregateFunction545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_aggregateFunction559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_aggregateFunction573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_aggregateFunction587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variable614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_queryDeclaration641 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_queryDeclaration645 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_queryDeclaration647 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_ioStates_in_queryDeclaration649 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_queryDeclaration651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ioState_in_ioStates691 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ioStates696 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_ioState_in_ioStates700 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_41_in_ioState726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ioState740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_factStoreDeclaration766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_factDeclaration791 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_factDeclaration793 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_predicate_in_factDeclaration795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_ruleDeclaration830 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleDeclaration832 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleDeclaration834 = new BitSet(new long[]{0x0001000000000280L});
    public static final BitSet FOLLOW_prerequisites_in_ruleDeclaration838 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleDeclaration840 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_predicate_in_ruleDeclaration842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prerequisite_in_prerequisites886 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_prerequisites891 = new BitSet(new long[]{0x0001000000000280L});
    public static final BitSet FOLLOW_prerequisite_in_prerequisites895 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_predicatePrerequisite_in_prerequisite922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionPrerequisite_in_prerequisite934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negatablePredicate_in_predicatePrerequisite959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Expression_in_expressionPrerequisite984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_negatablePredicate1016 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_predicate_in_negatablePredicate1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_negatablePredicate1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_existingPredicate_in_predicate1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newPredicate_in_predicate1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_existingPredicate1103 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_existingPredicate1105 = new BitSet(new long[]{0x0000000000007E80L});
    public static final BitSet FOLLOW_terms_in_existingPredicate1109 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_existingPredicate1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_newPredicate1143 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_newPredicate1145 = new BitSet(new long[]{0x0000000000007E80L});
    public static final BitSet FOLLOW_terms_in_newPredicate1149 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_newPredicate1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1191 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_terms1196 = new BitSet(new long[]{0x0000000000007E80L});
    public static final BitSet FOLLOW_term_in_terms1200 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_complexTerm_in_term1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_complexTerm1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_classOrInterfaceType1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedName1409 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_qualifiedName1412 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedName1414 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_50_in_primitiveType1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_primitiveType1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_primitiveType1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_primitiveType1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_primitiveType1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_primitiveType1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_primitiveType1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_primitiveType1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_existingPredicate_in_synpred21_Take1055 = new BitSet(new long[]{0x0000000000000002L});

}
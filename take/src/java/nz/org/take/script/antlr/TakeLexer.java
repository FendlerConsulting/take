// $ANTLR 3.1.1 /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g 2009-10-12 23:51:38

package nz.org.take.script.antlr;

import java.util.List;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TakeLexer extends Lexer {
    public static final int FloatTypeSuffix=18;
    public static final int OctalLiteral=12;
    public static final int LineComment=30;
    public static final int Exponent=17;
    public static final int Newline=6;
    public static final int AnnotationValue=7;
    public static final int AnnotationKey=22;
    public static final int EOF=-1;
    public static final int HexDigit=15;
    public static final int Identifier=8;
    public static final int T__55=55;
    public static final int BlockComment=29;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int LocalAnnotationKey=5;
    public static final int IDDigit=27;
    public static final int Whitespace=28;
    public static final int T__50=50;
    public static final int NamespaceDelimiter=25;
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
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int LocalAnnotation=24;
    public static final int T__37=37;
    public static final int GlobalAnnotationKey=4;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int UnicodeEscape=20;
    public static final int FloatingPointLiteral=13;
    public static final int GlobalAnnotation=23;
    public static final int EscapeSequence=19;
    public static final int OctalEscape=21;
    public static final int Letter=26;

    // Workaround until getText(), and setText() work as expected within lexer fragments
    private String lastAnnotationValue = null;

    private List<Token> tokens = new LinkedList<Token>();

    public void emit(Token token) {
        state.token = token;
        tokens.add(token);
    }

    public Token nextToken() {
        super.nextToken();
        
        if (tokens.size() == 0) {
            return Token.EOF_TOKEN;
        }
        
        return tokens.remove(0);
    }


    // delegates
    // delegators

    public TakeLexer() {;} 
    public TakeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TakeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g"; }

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:31:7: ( 'var' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:31:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:32:7: ( ',' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:32:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:33:7: ( 'ref' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:33:9: 'ref'
            {
            match("ref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:34:7: ( 'aggregation' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:34:9: 'aggregation'
            {
            match("aggregation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:35:7: ( '=' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:35:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:36:7: ( 'avg' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:36:9: 'avg'
            {
            match("avg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:37:7: ( 'min' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:37:9: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:38:7: ( 'max' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:38:9: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:39:7: ( 'sum' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:39:9: 'sum'
            {
            match("sum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:40:7: ( 'count' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:40:9: 'count'
            {
            match("count"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:41:7: ( 'query' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:41:9: 'query'
            {
            match("query"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:42:7: ( '|' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:42:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:43:7: ( 'in' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:43:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:44:7: ( 'out' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:44:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:45:7: ( 'external' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:45:9: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:46:7: ( ':' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:46:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:47:7: ( 'if' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:47:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:48:7: ( 'then' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:48:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:49:7: ( 'and' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:49:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:50:7: ( 'not' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:50:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:51:7: ( '.' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:51:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:52:7: ( 'boolean' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:52:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:53:7: ( 'char' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:53:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:54:7: ( 'byte' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:54:9: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:55:7: ( 'short' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:55:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:56:7: ( 'int' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:56:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:57:7: ( 'long' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:57:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:58:7: ( 'float' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:58:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:59:7: ( 'double' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:59:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "HexLiteral"
    public final void mHexLiteral() throws RecognitionException {
        try {
            int _type = HexLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:12: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:14: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:28: ( HexDigit )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:28: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:38: ( IntegerTypeSuffix )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:548:38: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HexLiteral"

    // $ANTLR start "DecimalLiteral"
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:16: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:18: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:19: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:25: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:34: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:34: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:45: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:550:45: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DecimalLiteral"

    // $ANTLR start "OctalLiteral"
    public final void mOctalLiteral() throws RecognitionException {
        try {
            int _type = OctalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:14: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:16: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:20: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:21: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:32: ( IntegerTypeSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:552:32: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OctalLiteral"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:555:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:555:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "IntegerTypeSuffix"
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:558:19: ( ( 'l' | 'L' ) )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:558:21: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IntegerTypeSuffix"

    // $ANTLR start "FloatingPointLiteral"
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match('.'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:25: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:37: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:47: ( FloatTypeSuffix )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:561:47: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:13: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:25: ( Exponent )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:25: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:35: ( FloatTypeSuffix )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:562:35: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:563:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:563:9: ( '0' .. '9' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:563:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    mExponent(); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:563:30: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:563:30: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:564:9: ( '0' .. '9' )+ FloatTypeSuffix
                    {
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:564:9: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:564:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    mFloatTypeSuffix(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointLiteral"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:568:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:568:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:568:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:568:33: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:568:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatTypeSuffix"
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:571:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:571:19: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatTypeSuffix"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:574:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:574:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:574:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\\') ) {
                    alt21=1;
                }
                else if ( ((LA21_0>='\u0000' && LA21_0<='!')||(LA21_0>='#' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:574:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:574:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:579:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt22=1;
                    }
                    break;
                case 'u':
                    {
                    alt22=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt22=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:579:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:580:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:581:9: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                int LA23_1 = input.LA(2);

                if ( ((LA23_1>='0' && LA23_1<='3')) ) {
                    int LA23_2 = input.LA(3);

                    if ( ((LA23_2>='0' && LA23_2<='7')) ) {
                        int LA23_4 = input.LA(4);

                        if ( ((LA23_4>='0' && LA23_4<='7')) ) {
                            alt23=1;
                        }
                        else {
                            alt23=2;}
                    }
                    else {
                        alt23=3;}
                }
                else if ( ((LA23_1>='4' && LA23_1<='7')) ) {
                    int LA23_3 = input.LA(3);

                    if ( ((LA23_3>='0' && LA23_3<='7')) ) {
                        alt23=2;
                    }
                    else {
                        alt23=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:14: ( '0' .. '3' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:25: ( '0' .. '7' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:36: ( '0' .. '7' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:586:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:587:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:587:14: ( '0' .. '7' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:587:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:587:25: ( '0' .. '7' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:587:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:588:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:588:14: ( '0' .. '7' )
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:588:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:593:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:593:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "GlobalAnnotation"
    public final void mGlobalAnnotation() throws RecognitionException {
        try {
            int _type = GlobalAnnotation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token key=null;
            Token value=null;

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:597:5: ( '@@' key= AnnotationKey '=' value= AnnotationValue )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:597:9: '@@' key= AnnotationKey '=' value= AnnotationValue
            {
            match("@@"); 

            int keyStart732 = getCharIndex();
            mAnnotationKey(); 
            key = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, keyStart732, getCharIndex()-1);
            match('='); 
            int valueStart738 = getCharIndex();
            mAnnotationValue(); 
            value = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, valueStart738, getCharIndex()-1);

                        emit(new CommonToken(GlobalAnnotationKey, (key!=null?key.getText():null)));
                        emit(new CommonToken(AnnotationValue, lastAnnotationValue));
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GlobalAnnotation"

    // $ANTLR start "LocalAnnotation"
    public final void mLocalAnnotation() throws RecognitionException {
        try {
            int _type = LocalAnnotation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token key=null;
            Token value=null;

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:605:5: ( '@' key= AnnotationKey '=' value= AnnotationValue )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:605:9: '@' key= AnnotationKey '=' value= AnnotationValue
            {
            match('@'); 
            int keyStart772 = getCharIndex();
            mAnnotationKey(); 
            key = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, keyStart772, getCharIndex()-1);
            match('='); 
            int valueStart778 = getCharIndex();
            mAnnotationValue(); 
            value = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, valueStart778, getCharIndex()-1);

                        emit(new CommonToken(LocalAnnotationKey, (key!=null?key.getText():null)));
                        emit(new CommonToken(AnnotationValue, lastAnnotationValue));
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LocalAnnotation"

    // $ANTLR start "AnnotationKey"
    public final void mAnnotationKey() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:614:5: ( Identifier ( NamespaceDelimiter Identifier )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:614:7: Identifier ( NamespaceDelimiter Identifier )*
            {
            mIdentifier(); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:614:18: ( NamespaceDelimiter Identifier )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0=='.'||LA24_0==':') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:614:19: NamespaceDelimiter Identifier
            	    {
            	    mNamespaceDelimiter(); 
            	    mIdentifier(); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "AnnotationKey"

    // $ANTLR start "NamespaceDelimiter"
    public final void mNamespaceDelimiter() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:619:5: ( ':' | '.' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:
            {
            if ( input.LA(1)=='.'||input.LA(1)==':' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NamespaceDelimiter"

    // $ANTLR start "AnnotationValue"
    public final void mAnnotationValue() throws RecognitionException {
        try {
            Token Newline1=null;

             int startIndex = getCharIndex(); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:625:5: ( ( options {greedy=false; } : . )+ Newline )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:625:9: ( options {greedy=false; } : . )+ Newline
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:625:9: ( options {greedy=false; } : . )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='\r') ) {
                    alt25=2;
                }
                else if ( (LA25_0=='\n') ) {
                    alt25=2;
                }
                else if ( ((LA25_0>='\u0000' && LA25_0<='\t')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:625:39: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            int Newline1Start884 = getCharIndex();
            mNewline(); 
            Newline1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, Newline1Start884, getCharIndex()-1);

                        int endIndex = getCharIndex() - 1;
                        int whitespace = (Newline1!=null?Newline1.getText():null).length();
                        
                        // Workaround until getText(), and setText() work as expected within lexer fragments
                        lastAnnotationValue = input.substring(startIndex, endIndex - whitespace).trim();
                    

            }

        }
        finally {
        }
    }
    // $ANTLR end "AnnotationValue"

    // $ANTLR start "Expression"
    public final void mExpression() throws RecognitionException {
        try {
            int _type = Expression;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:636:5: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )+ '\\'' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:636:9: '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )+ '\\''
            {
            match('\''); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:636:14: ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='\\') ) {
                    alt26=1;
                }
                else if ( ((LA26_0>='\u0000' && LA26_0<='&')||(LA26_0>='(' && LA26_0<='[')||(LA26_0>=']' && LA26_0<='\uFFFF')) ) {
                    alt26=2;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:636:16: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:636:33: ~ ( '\\\\' | '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            match('\''); 

                        String expression = getText().substring(1, getText().length() - 1); // strip single quotes
                        setText(expression.replaceAll("\\'", "'"));
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Expression"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:644:5: ( Letter ( Letter | IDDigit )* )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:644:9: Letter ( Letter | IDDigit )*
            {
            mLetter(); 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:644:16: ( Letter | IDDigit )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='0' && LA27_0<='9')||(LA27_0>='A' && LA27_0<='Z')||LA27_0=='_'||(LA27_0>='a' && LA27_0<='z')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:649:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "IDDigit"
    public final void mIDDigit() throws RecognitionException {
        try {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:656:5: ( '0' .. '9' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:656:9: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "IDDigit"

    // $ANTLR start "Newline"
    public final void mNewline() throws RecognitionException {
        try {
            int _type = Newline;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:660:5: ( ( '\\r' )? '\\n' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:660:9: ( '\\r' )? '\\n'
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:660:9: ( '\\r' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\r') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:660:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Newline"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             _channel=HIDDEN; 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:665:5: ( ( ' ' | '\\t' )+ )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:665:9: ( ' ' | '\\t' )+
            {
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:665:9: ( ' ' | '\\t' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0=='\t'||LA29_0==' ') ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Whitespace"

    // $ANTLR start "BlockComment"
    public final void mBlockComment() throws RecognitionException {
        try {
            int _type = BlockComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             _channel=HIDDEN; 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:670:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:670:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:670:14: ( options {greedy=false; } : . )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0=='*') ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1=='/') ) {
                        alt30=2;
                    }
                    else if ( ((LA30_1>='\u0000' && LA30_1<='.')||(LA30_1>='0' && LA30_1<='\uFFFF')) ) {
                        alt30=1;
                    }


                }
                else if ( ((LA30_0>='\u0000' && LA30_0<=')')||(LA30_0>='+' && LA30_0<='\uFFFF')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:670:44: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BlockComment"

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             _channel=HIDDEN; 
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:675:5: ( '//' ( options {greedy=false; } : . )* Newline )
            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:675:9: '//' ( options {greedy=false; } : . )* Newline
            {
            match("//"); 

            // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:675:14: ( options {greedy=false; } : . )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0=='\r') ) {
                    alt31=2;
                }
                else if ( (LA31_0=='\n') ) {
                    alt31=2;
                }
                else if ( ((LA31_0>='\u0000' && LA31_0<='\t')||(LA31_0>='\u000B' && LA31_0<='\f')||(LA31_0>='\u000E' && LA31_0<='\uFFFF')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:675:44: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            mNewline(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LineComment"

    public void mTokens() throws RecognitionException {
        // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:8: ( T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | StringLiteral | GlobalAnnotation | LocalAnnotation | Expression | Identifier | Newline | Whitespace | BlockComment | LineComment )
        int alt32=42;
        alt32 = dfa32.predict(input);
        switch (alt32) {
            case 1 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:10: T__31
                {
                mT__31(); 

                }
                break;
            case 2 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:16: T__32
                {
                mT__32(); 

                }
                break;
            case 3 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:22: T__33
                {
                mT__33(); 

                }
                break;
            case 4 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:28: T__34
                {
                mT__34(); 

                }
                break;
            case 5 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:34: T__35
                {
                mT__35(); 

                }
                break;
            case 6 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:40: T__36
                {
                mT__36(); 

                }
                break;
            case 7 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:46: T__37
                {
                mT__37(); 

                }
                break;
            case 8 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:52: T__38
                {
                mT__38(); 

                }
                break;
            case 9 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:58: T__39
                {
                mT__39(); 

                }
                break;
            case 10 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:64: T__40
                {
                mT__40(); 

                }
                break;
            case 11 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:70: T__41
                {
                mT__41(); 

                }
                break;
            case 12 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:76: T__42
                {
                mT__42(); 

                }
                break;
            case 13 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:82: T__43
                {
                mT__43(); 

                }
                break;
            case 14 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:88: T__44
                {
                mT__44(); 

                }
                break;
            case 15 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:94: T__45
                {
                mT__45(); 

                }
                break;
            case 16 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:100: T__46
                {
                mT__46(); 

                }
                break;
            case 17 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:106: T__47
                {
                mT__47(); 

                }
                break;
            case 18 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:112: T__48
                {
                mT__48(); 

                }
                break;
            case 19 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:118: T__49
                {
                mT__49(); 

                }
                break;
            case 20 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:124: T__50
                {
                mT__50(); 

                }
                break;
            case 21 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:130: T__51
                {
                mT__51(); 

                }
                break;
            case 22 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:136: T__52
                {
                mT__52(); 

                }
                break;
            case 23 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:142: T__53
                {
                mT__53(); 

                }
                break;
            case 24 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:148: T__54
                {
                mT__54(); 

                }
                break;
            case 25 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:154: T__55
                {
                mT__55(); 

                }
                break;
            case 26 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:160: T__56
                {
                mT__56(); 

                }
                break;
            case 27 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:166: T__57
                {
                mT__57(); 

                }
                break;
            case 28 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:172: T__58
                {
                mT__58(); 

                }
                break;
            case 29 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:178: T__59
                {
                mT__59(); 

                }
                break;
            case 30 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:184: HexLiteral
                {
                mHexLiteral(); 

                }
                break;
            case 31 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:195: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 32 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:210: OctalLiteral
                {
                mOctalLiteral(); 

                }
                break;
            case 33 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:223: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 34 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:244: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 35 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:258: GlobalAnnotation
                {
                mGlobalAnnotation(); 

                }
                break;
            case 36 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:275: LocalAnnotation
                {
                mLocalAnnotation(); 

                }
                break;
            case 37 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:291: Expression
                {
                mExpression(); 

                }
                break;
            case 38 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:302: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 39 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:313: Newline
                {
                mNewline(); 

                }
                break;
            case 40 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:321: Whitespace
                {
                mWhitespace(); 

                }
                break;
            case 41 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:332: BlockComment
                {
                mBlockComment(); 

                }
                break;
            case 42 :
                // /Users/carlos/Projects/Eclipse Workspace/take/grammar/Take.g:1:345: LineComment
                {
                mLineComment(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA18_eotS =
        "\6\uffff";
    static final String DFA18_eofS =
        "\6\uffff";
    static final String DFA18_minS =
        "\2\56\4\uffff";
    static final String DFA18_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\1";
    static final String DFA18_specialS =
        "\6\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\1\12\uffff\1\4\1\3\1\4\35\uffff\1\4\1\3\1\4",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "560:1: FloatingPointLiteral : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix );";
        }
    }
    static final String DFA32_eotS =
        "\1\uffff\1\33\1\uffff\2\33\1\uffff\4\33\1\uffff\3\33\1\uffff\2\33"+
        "\1\61\4\33\2\72\7\uffff\14\33\1\115\1\116\4\33\2\uffff\5\33\1\uffff"+
        "\1\130\1\uffff\1\72\4\uffff\1\131\1\132\1\33\1\134\1\135\1\136\1"+
        "\137\1\140\4\33\1\145\2\uffff\1\146\2\33\1\151\5\33\3\uffff\1\33"+
        "\5\uffff\2\33\1\162\1\33\2\uffff\1\33\1\165\1\uffff\1\33\1\167\1"+
        "\170\3\33\1\174\1\175\1\uffff\1\176\1\33\1\uffff\1\33\2\uffff\1"+
        "\u0081\2\33\3\uffff\2\33\1\uffff\1\u0086\2\33\1\u0089\1\uffff\1"+
        "\33\1\u008b\1\uffff\1\33\1\uffff\1\33\1\u008e\1\uffff";
    static final String DFA32_eofS =
        "\u008f\uffff";
    static final String DFA32_minS =
        "\1\11\1\141\1\uffff\1\145\1\147\1\uffff\1\141\2\150\1\165\1\uffff"+
        "\1\146\1\165\1\170\1\uffff\1\150\1\157\1\60\2\157\1\154\1\157\2"+
        "\56\1\uffff\1\100\4\uffff\1\52\1\162\1\146\2\147\1\144\1\156\1\170"+
        "\1\155\1\157\1\165\1\141\1\145\2\60\2\164\1\145\1\164\2\uffff\1"+
        "\157\1\164\1\156\1\157\1\165\1\uffff\1\56\1\uffff\1\56\4\uffff\2"+
        "\60\1\162\5\60\1\162\1\156\2\162\1\60\2\uffff\1\60\1\145\1\156\1"+
        "\60\1\154\1\145\1\147\1\141\1\142\3\uffff\1\145\5\uffff\2\164\1"+
        "\60\1\171\2\uffff\1\162\1\60\1\uffff\1\145\2\60\1\164\1\154\1\147"+
        "\2\60\1\uffff\1\60\1\156\1\uffff\1\141\2\uffff\1\60\1\145\1\141"+
        "\3\uffff\1\141\1\156\1\uffff\1\60\1\164\1\154\1\60\1\uffff\1\151"+
        "\1\60\1\uffff\1\157\1\uffff\1\156\1\60\1\uffff";
    static final String DFA32_maxS =
        "\1\174\1\141\1\uffff\1\145\1\166\1\uffff\1\151\1\165\1\157\1\165"+
        "\1\uffff\1\156\1\165\1\170\1\uffff\1\150\1\157\1\71\1\171\1\157"+
        "\1\154\1\157\1\170\1\146\1\uffff\1\172\4\uffff\1\57\1\162\1\146"+
        "\2\147\1\144\1\156\1\170\1\155\1\157\1\165\1\141\1\145\2\172\2\164"+
        "\1\145\1\164\2\uffff\1\157\1\164\1\156\1\157\1\165\1\uffff\1\146"+
        "\1\uffff\1\146\4\uffff\2\172\1\162\5\172\1\162\1\156\2\162\1\172"+
        "\2\uffff\1\172\1\145\1\156\1\172\1\154\1\145\1\147\1\141\1\142\3"+
        "\uffff\1\145\5\uffff\2\164\1\172\1\171\2\uffff\1\162\1\172\1\uffff"+
        "\1\145\2\172\1\164\1\154\1\147\2\172\1\uffff\1\172\1\156\1\uffff"+
        "\1\141\2\uffff\1\172\1\145\1\141\3\uffff\1\141\1\156\1\uffff\1\172"+
        "\1\164\1\154\1\172\1\uffff\1\151\1\172\1\uffff\1\157\1\uffff\1\156"+
        "\1\172\1\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\2\uffff\1\5\4\uffff\1\14\3\uffff\1\20\11\uffff\1\42"+
        "\1\uffff\1\45\1\46\1\47\1\50\23\uffff\1\25\1\41\5\uffff\1\36\1\uffff"+
        "\1\37\1\uffff\1\43\1\44\1\51\1\52\15\uffff\1\15\1\21\11\uffff\1"+
        "\40\1\1\1\3\1\uffff\1\6\1\23\1\7\1\10\1\11\4\uffff\1\32\1\16\2\uffff"+
        "\1\24\10\uffff\1\27\2\uffff\1\22\1\uffff\1\30\1\33\3\uffff\1\31"+
        "\1\12\1\13\2\uffff\1\34\4\uffff\1\35\2\uffff\1\26\1\uffff\1\17\2"+
        "\uffff\1\4";
    static final String DFA32_specialS =
        "\u008f\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\35\1\34\2\uffff\1\34\22\uffff\1\35\1\uffff\1\30\4\uffff\1"+
            "\32\4\uffff\1\2\1\uffff\1\21\1\36\1\26\11\27\1\16\2\uffff\1"+
            "\5\2\uffff\1\31\32\33\4\uffff\1\33\1\uffff\1\4\1\22\1\10\1\25"+
            "\1\15\1\24\2\33\1\13\2\33\1\23\1\6\1\20\1\14\1\33\1\11\1\3\1"+
            "\7\1\17\1\33\1\1\4\33\1\uffff\1\12",
            "\1\37",
            "",
            "\1\40",
            "\1\41\6\uffff\1\43\7\uffff\1\42",
            "",
            "\1\45\7\uffff\1\44",
            "\1\47\14\uffff\1\46",
            "\1\51\6\uffff\1\50",
            "\1\52",
            "",
            "\1\54\7\uffff\1\53",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "\12\62",
            "\1\63\11\uffff\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\62\1\uffff\10\71\2\62\12\uffff\3\62\21\uffff\1\70\13\uffff"+
            "\3\62\21\uffff\1\70",
            "\1\62\1\uffff\12\73\12\uffff\3\62\35\uffff\3\62",
            "",
            "\1\74\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "",
            "",
            "\1\76\4\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\23\33\1\114\6\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\1\62\1\uffff\10\71\2\62\12\uffff\3\62\35\uffff\3\62",
            "",
            "\1\62\1\uffff\12\73\12\uffff\3\62\35\uffff\3\62",
            "",
            "",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\133",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\147",
            "\1\150",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "",
            "",
            "",
            "\1\157",
            "",
            "",
            "",
            "",
            "",
            "\1\160",
            "\1\161",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\163",
            "",
            "",
            "\1\164",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\166",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\177",
            "",
            "\1\u0080",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0082",
            "\1\u0083",
            "",
            "",
            "",
            "\1\u0084",
            "\1\u0085",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0087",
            "\1\u0088",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u008a",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u008c",
            "",
            "\1\u008d",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | StringLiteral | GlobalAnnotation | LocalAnnotation | Expression | Identifier | Newline | Whitespace | BlockComment | LineComment );";
        }
    }
 

}
package mx.jcc.lexer;

import mx.jcc.syntax.sym;
import java_cup.runtime.*;

%%
%class Lexer


%line
%column
%cup

%{   
    
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {	  
    	return new Symbol(type, yyline, yycolumn, value);
    }
    
%}

white=[ \t\r]+
id = [a-zA-Z][a-zA-Z0-9]*


%%

<YYINITIAL> {
    "terminal" { return symbol(sym.KEYWORD_TERMINAL); }
    "nonterm" { return symbol(sym.KEYWORD_NONTERM); }
    "->" { return symbol(sym.FLECHA); }
    "\n" { return symbol(sym.EOL); }
    {white} { /*return W_SPACE;*/ }
    "," { return symbol(sym.COMMA); }
    {id} { return symbol(sym.VAR, yytext()); }
}
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
package codigo;
import static codigo.Token.*;
%%
%class Lexer
%type Token

letra=[a-zA-Z_]

digito=[0-9]

opAg=[\(,\)]

opAr=[*,\+,\-,/]

com=[\,]


%{
    public String lexeme;
%}
%%

{com} {lexeme=yytext();return coma;}


int|float|char {lexeme=yytext(); return reservada;}

(" "|"\t"|\r)+ {/*Ignore*/}

{opAg} {lexeme=yytext(); return agrupacion;}
{opAr} {lexeme=yytext(); return aritmetico;}


"//".* {/*Ignore*/}
"\n" {lexeme=yytext(); return salto;}
"=" {lexeme=yytext(); return asignacion;}
";"	{lexeme=yytext();return finSentencia;}
":"	{lexeme=yytext();return puntos;}

{letra}({letra}|{digito})* {lexeme=yytext(); return id;}
{digito}+ {lexeme=yytext(); return num;}

 . {lexeme=yytext(); return ERROR;}


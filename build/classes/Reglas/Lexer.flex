package Reglas;
import Token.Tokens;
import static Token.Tokens.*;
%%
%class Lexer
%type Tokens

L = [a-zA-Z_]+
D = [0-9]+

espacio = [ \t\r\n]+
%{
    public String lexeme;
%}
%%
{espacio} {/*Ignore*/}
("+" | "-" | "*" | "/" | "%")
{
    lexeme = yytext();
    return Operador_aritmetico;
}
("$" | "@" | "_")
{
    lexeme = yytext();
    return Operador_logico;
}
(">" | "<" | "#" | "^")
{
    lexeme = yytext();
    return Operador_relacional;
}
("=")
{
    lexeme = yytext();
    return Operador_asignacion;
}
("(" | ")" | "{" | "}" | "[" | "]" | ";" | "," | "." | "\\")
{
    lexeme = yytext();
    return Separador;
}

(private | protected | public | if | String | main | else | while | break | for | switch )
{
    lexeme = yytext();
    return Palabra_reservada;
}

{L}({L}|{D})*
{
    lexeme = yytext();
    return Identificador;
}

("(-"{D}+")")|{D}+
{
    lexeme = yytext();
    return Numero_entero;
}

{D}+"."{D}* | {D}*"."{D}+
{
    lexeme = yytext();
    return Numero_decimal;
}

.
{
    return ERROR;
}

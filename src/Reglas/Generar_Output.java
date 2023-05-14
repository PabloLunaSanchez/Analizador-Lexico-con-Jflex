package Reglas;

import Token.Tokens;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Generar_Output {

    public static void main(String[] args) {
        try {
            File archivoEntrada = new File("C:/Users/Usuario/Documents/NetBeansProjects/AnalizadorLexico_Jflex/src/Input_Output_Txt/input.txt");
            FileReader fr = new FileReader(archivoEntrada);
            Lexer lexer = new Lexer(fr);
            File archivoSalida = new File("C:/Users/Usuario/Documents/NetBeansProjects/AnalizadorLexico_Jflex/src/Input_Output_Txt/output.txt");
            FileWriter fw = new FileWriter(archivoSalida);

            Tokens token;
            while ((token = lexer.yylex()) != null) {
                // Obtener el lexema del token (si aplica)
                String lexema = lexer.lexeme;

                // Escribir token y lexema en el archivo de salida
                fw.write(token.toString() + ": " + lexema + "\n");
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico_jflex;

import java.io.File;


/**
 *
 * @author Usuario
 */
public class GeneraArchivoLexer {
    public static void main(String[] args) {
        String path = "C:/Users/Usuario/Documents/NetBeansProjects/AnalizadorLexico_Jflex/src/Reglas/Lexer.flex";
        generarLexer(path);
    }
    
    public static void generarLexer(String ruta){
        File file = new File(ruta);
        JFlex.Main.generate(file);
    }
}

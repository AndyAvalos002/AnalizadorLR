/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author claudia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String path="C:/Users/jaime/OneDrive/Documentos/NetBeansProjects/AnalizadorGramaticaLR/src/codigo/Lexer.flex";
        generarLexer(path);
        //Ya no necesitamos en código de arriba porque
        /*try{
            //probamos nuestra clase Lexer.java
            probarLexerFile();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }*/
    }

    public static void generarLexer(String path){
        File file=new File(path);
        JFlex.Main.generate(file);
    }


}

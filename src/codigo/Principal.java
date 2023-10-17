package codigo;


import jflex.exceptions.SilentExit;

/**
 *
 * @author andrea
 */
public class Principal {

    public static void main(String omega[]) {
        String lexerFile = System.getProperty("user.dir") + "/src/codigo/Lexer.flex";
        try {
            jflex.Main.generate(new String[]{lexerFile});
        } catch (SilentExit ex) {
            System.out.println("Error al compilar/generar el archivo flex: " + ex);
        }
    }
}

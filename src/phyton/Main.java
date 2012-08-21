/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phyton;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author uno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {

        // TODO code application logic here
            FileInputStream file = null;
                         
                        String filename = "archi.tst";
                        try {
                                file = new FileInputStream(filename);
                        } catch (FileNotFoundException e1) {
                                System.out.println("No se pudo abrir el archivo: " + filename);
                                System.exit(1);
                        }
                        sintaxer sin = new sintaxer(new BufferedInputStream(file));
       /*               lexer lexer = new lexer(new BufferedInputStream(file));
                          token token = lexer.getNextToken();

                          do {

                              System.out.println("Token:" + token.NombreToken(token.getType())+": \""+token.getLexema()+"\" "+"en linea: ");
                                token = lexer.getNextToken();
                     } while (token.getType() != token.EOF);
                                System.out.println("Token:" + token.NombreToken(token.getType())+": \""+token.getLexema()+"\"");
*/
    }

}

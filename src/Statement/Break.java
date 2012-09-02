/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Statement;

/**
 *
 * @author uno
 */
public class Break extends statement{

    public Break(int linea)
    {
        this.line=linea;
    }
    @Override
    public String toString() {
       String str="Estoy en un Break";
       return str;
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

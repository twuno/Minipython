/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class Multiplicacion extends BinaryExp{
public Multiplicacion(int linea, Expr v1, Expr v2)
{
    super(v1, v2);
    line=linea;
    
}
    @Override
    public String toString() {
        String str="multiplicacion";
        return str;
     
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

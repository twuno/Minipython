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
    Expr exp1, exp2;
public Multiplicacion(int linea, Expr exp1, Expr exp2)
{
 this.exp1=exp1;
       this.exp2=exp2;
          line=linea;
    
}
    @Override
    public String toString() {
        String str="multiplicacion";
        return str;
     
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

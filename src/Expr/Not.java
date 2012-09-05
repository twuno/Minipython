/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class Not extends UnaryExp{
    Expr exp;
    
    public Not(int linea, Expr exp)
    {
         super(exp);
         this.line=linea;
       
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

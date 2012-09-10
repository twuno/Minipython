/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class Not extends BinaryExp{
    Expr exp,exp2;
    
    public Not(int linea, Expr exp,Expr exp2)
    {
         super(exp,exp2);
         this.line=linea;
       
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class MayorQue extends BinaryExp{
    Expr exp1, exp2;
    
    public MayorQue(int linea, Expr exp1, Expr exp2)
    {
       this.exp1=exp1;
       this.exp2=exp2;
        this.line=linea;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

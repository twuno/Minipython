/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class Or extends BinaryExp{
    Expr exp1, exp2;
    
    public Or(int linea, Expr exp1, Expr exp2)
    {
        super(exp1, exp2);
        this.line=linea;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

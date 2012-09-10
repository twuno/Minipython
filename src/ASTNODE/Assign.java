/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTNODE;

import Expr.Expr;

/**
 *
 * @author uno
 */
public class Assign extends ASTNode{
    private Expr Lval;
    private Expr Rval2;
public Assign(int line,Expr expr1,Expr expr2)
{
    this.line=line;
    this.Lval=expr1;
    this.Rval2=expr2;
}
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the arr
     */
    public Expr getLval() {
        return Lval;
    }

    /**
     * @param arr the arr to set
     */
    public void setLval(Expr arr) {
        this.Lval = arr;
    }

    /**
     * @return the Rval2
     */
    public Expr getRval2() {
        return Rval2;
    }

    /**
     * @param Rval2 the Rval2 to set
     */
    public void setRval2(Expr Rval2) {
        this.Rval2 = Rval2;
    }
    
}

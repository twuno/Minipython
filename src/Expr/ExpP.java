/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class ExpP extends Expr{
private Expr expr;
    public ExpP(Expr expr) {
        this.expr=expr;
    }
    public ExpP() {
        this.expr=null;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the expr
     */
    public Expr getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(Expr expr) {
        this.expr = expr;
    }
    
}
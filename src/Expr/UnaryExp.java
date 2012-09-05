/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;

/**
 *
 * @author uno
 */
public abstract class UnaryExp extends Expr {
private ASTNode expr;

public UnaryExp(ASTNode exp1)
{
    this.expr=exp1;
}

    /**
     * @return the expr
     */
    public ASTNode getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(ASTNode expr) {
        this.expr = expr;
    }
  
    
    
}

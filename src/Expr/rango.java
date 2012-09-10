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
public class rango extends BinaryExp{
    private ASTNode e1;
    private ASTNode e2;

public rango(int line,Expr e1,Expr e2)
{
    this.e1=e1;
       this.e2=e2;
      
    this.line=line;

}
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the e1
     */
    public ASTNode getE1() {
        return e1;
    }

    /**
     * @param e1 the e1 to set
     */
    public void setE1(ASTNode e1) {
        this.e1 = e1;
    }

    /**
     * @return the e2
     */
    public ASTNode getE2() {
        return e2;
    }

    /**
     * @param e2 the e2 to set
     */
    public void setE2(ASTNode e2) {
        this.e2 = e2;
    }
    
}

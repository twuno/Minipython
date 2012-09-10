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
ASTNode e1,e2;

public rango(int line,Expr e1,Expr e2)
{
    super(e1, e2);
    this.line=line;

}
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

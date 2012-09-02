/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Statement;

import ASTNODE.ASTNode;

/**
 *
 * @author uno
 */
public class While extends statement{
    ASTNode expr;
    ASTNode block;
    
    public While(int linea,ASTNode ex, ASTNode bl)
    {
        this.line=linea;
        this.expr=ex;
        this.block=bl;
    }
    @Override
    public String toString() {
        String str="En el while";
        return str;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

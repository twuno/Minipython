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
public class ReturnStatement extends statement{
    ASTNode expr;
    
    public ReturnStatement(int linea, ASTNode exp)
    {
        this.expr=exp;
        this.line=linea;
    }
    @Override
    public String toString() {
        String str = "Esto es un Return";
        return str;
        //      throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

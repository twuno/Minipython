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
public class AssignStatement extends statement {

ASTNode Lval;
ASTNode Rval;
    @Override
    
    public String toString() {
        String str = "Estas en una Assign";
        return str;
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public AssignStatement(int linea,ASTNode leftValue, ASTNode RightValue)
    {
        this.line=linea;
        this.Lval=leftValue;
        this.Rval=RightValue;
    }
    
}

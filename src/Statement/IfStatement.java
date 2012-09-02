/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Statement;

import ASTNODE.ASTNode;
import java.util.ArrayList;

/**
 *
 * @author uno
 */
public class IfStatement extends statement{
    ASTNode expr;
    ASTNode ifBlock;
    ArrayList<ASTNode> elifBlockList;
    ASTNode elseBlock;
    
    
    @Override
    public String toString() {
        String str="Estoy en un If";
        return str;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public IfStatement(ASTNode expr, ASTNode ifBlock, ArrayList<ASTNode> elifB, ASTNode elseB,int line)
    {
        this.line=line;
        this.expr=expr;
        this.ifBlock=ifBlock;
        this.elifBlockList =elifB;
        this.elseBlock=elseB;
    }
}

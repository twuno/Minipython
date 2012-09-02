/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTNODE;

import java.util.ArrayList;

/**
 *
 * @author uno
 */
public class BlockNode extends ASTNode{
    ArrayList<ASTNode> statements;
    
public BlockNode(int line,ArrayList<ASTNode> statements)
{
    this.line=line;
    this.statements=statements;
}   
    @Override
    public String toString() {
        String texto="Esta en un Bloque que comienza con en la linea "+Integer.toHexString(line);
        return texto;
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

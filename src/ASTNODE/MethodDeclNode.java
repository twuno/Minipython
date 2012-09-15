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
public class MethodDeclNode extends ASTNode{
    private String MethodName;
    private ArrayList<String> Arguments;
    private ASTNode block;
    
public MethodDeclNode(int line, String MethodName, ArrayList<String> Arguments, ASTNode block)
{
    this.line= line;
    this.MethodName=MethodName;
    this.Arguments=Arguments;
    this.block=block;
}
  public MethodDeclNode()
{
    this.line= 0;
    this.MethodName=null;
    this.Arguments=null;
    this.block=null;
}  
    @Override
    public String toString() {
            String retu;
            retu= "Metodo llamado: "+getMethodName() + " Empieza en la linea "+Integer.toString(line);
            return retu; 
                    
            //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the MethodName
     */
    public String getMethodName() {
        return MethodName;
    }

    /**
     * @param MethodName the MethodName to set
     */
    public void setMethodName(String MethodName) {
        this.MethodName = MethodName;
    }

    /**
     * @return the Arguments
     */
    public ArrayList<String> getArguments() {
        return Arguments;
    }

    /**
     * @param Arguments the Arguments to set
     */
    public void setArguments(ArrayList<String> Arguments) {
        this.Arguments = Arguments;
    }

    /**
     * @return the block
     */
    public ASTNode getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(ASTNode block) {
        this.block = block;
    }
    
}

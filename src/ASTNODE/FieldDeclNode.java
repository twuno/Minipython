/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTNODE;

/**
 *
 * @author uno
 */
 public class FieldDeclNode extends ASTNode{
    private ASTNode varName;
    private ASTNode right;
    
     public FieldDeclNode(int  line, ASTNode name, ASTNode right)
    {
        this.line=line;
        this.varName=name;
        this.right=right;
    }

        public FieldDeclNode()
    {
        this.line=0;
        this.varName=null;
        this.right=null;
    }
        
    @Override
    public String toString() {
        String sitio;
        sitio="Estas en un field declaration Node";
        return sitio;
                
                
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the varName
     */
    public ASTNode getVarName() {
        return varName;
    }

    /**
     * @param varName the varName to set
     */
    public void setVarName(ASTNode varName) {
        this.varName = varName;
    }

    /**
     * @return the right
     */
    public ASTNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(ASTNode right) {
        this.right = right;
    }
    
}

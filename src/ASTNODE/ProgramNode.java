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
public class ProgramNode extends ASTNode{
    private String name;
   private ArrayList<ASTNode> field_decl_list;
   private ArrayList<ASTNode> method_decl_list;
    
    public ProgramNode(int line, String name, ArrayList<ASTNode> field_decl,ArrayList<ASTNode> method_decl )
    {
        this.line=line;
        this.name=name;
        this.field_decl_list=field_decl;
        this.method_decl_list=method_decl;
    }
     public ProgramNode()
    {
        this.line=0;
        this.name=null;
        this.field_decl_list=null;
        this.method_decl_list=null;
    }
    @Override
    public String toString() {
        String ret="Estoy en un ProgramNodo";
        return ret;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

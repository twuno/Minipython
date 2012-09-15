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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the field_decl_list
     */
    public ArrayList<ASTNode> getField_decl_list() {
        return field_decl_list;
    }

    /**
     * @param field_decl_list the field_decl_list to set
     */
    public void setField_decl_list(ArrayList<ASTNode> field_decl_list) {
        this.field_decl_list = field_decl_list;
    }

    /**
     * @return the method_decl_list
     */
    public ArrayList<ASTNode> getMethod_decl_list() {
        return method_decl_list;
    }

    /**
     * @param method_decl_list the method_decl_list to set
     */
    public void setMethod_decl_list(ArrayList<ASTNode> method_decl_list) {
        this.method_decl_list = method_decl_list;
    }
    
}

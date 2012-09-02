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
    String MethodName;
    ArrayList<String> Arguments;
    ASTNode block;
    
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
            retu= "Metodo llamado: "+MethodName + " Empieza en la linea "+Integer.toString(line);
            return retu; 
                    
            //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

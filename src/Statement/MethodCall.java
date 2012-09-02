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
public class MethodCall extends statement{
    String MethodName;
    ArrayList<ASTNode> methodParams;

public MethodCall(int line,String MethodName, ArrayList<ASTNode> method)
{
    this.line=line;
    this.MethodName=MethodName;
    this.methodParams=method;
}

    @Override
    public String toString() {
        String str;
        str="Dentro de un Method Call";
        return str;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
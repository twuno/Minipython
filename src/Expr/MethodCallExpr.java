/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;
import java.util.ArrayList;

/**
 *
 * @author uno
 */
public class MethodCallExpr extends Expr{
String methodName;
    ArrayList<ASTNode> methodParams;
    
    public MethodCallExpr(int linea,String name, ArrayList<ASTNode> param)
    {
        this.methodName=name;
        this.line=linea;
        this.methodParams=param;
    }
     
    @Override
    public String toString() {
//        throw new UnsupportedOperationException("Not supported yet.");
        String str="method declaration de Expr";
        return str;
    }
    
    
}

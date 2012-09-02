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
public class ForStatement extends statement{
    String Varname;
    ASTNode exprInicial;
    ASTNode exprFinal;
    ASTNode block;
    
    @Override
    public String toString() {
        String str;
        str="essto es un For";
        return str;   
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public ForStatement(int linea,String Varname, ASTNode exprInicial, ASTNode exprFinal, ASTNode block)
    {
        this.line=linea;
    this.Varname=Varname;
    this.exprInicial=exprInicial;
    this.exprFinal=exprFinal;
    this.block=block;
    }
    
    public ForStatement()
    {
        Varname=null;
        exprInicial=null;
        exprFinal=null;
        block=null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;
import type.Tipo;

/**
 *
 * @author uno
 */
public class LeftValueExpr extends Expr {
    ASTNode leftValue;
    
    public LeftValueExpr(int linea, ASTNode lv)
    {
        this.line=linea;
        this.leftValue=lv;
    }
    @Override
    public String toString() {
        String str="LeftValueExpresion";
        return str;
        
        //       throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
    @Override
    public int EvalI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

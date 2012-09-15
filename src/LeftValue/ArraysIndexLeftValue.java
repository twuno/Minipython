/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import ASTNODE.ASTNode;
import Expr.ExpP;
import type.Tipo;

/**
 *
 * @author uno
 */
public class ArraysIndexLeftValue extends leftValue {
    String Varname;
    ASTNode expr;
    public ArraysIndexLeftValue(int linea, String Varname, ASTNode exp)
    {
        this.Varname=Varname;
        this.expr=exp;
        this.line=linea;
    }
    @Override
    public String toString() {
        String str="Indice pa un Arreglo";
        return str;
        //        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

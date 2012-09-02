/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import ASTNODE.ASTNode;

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

    
}

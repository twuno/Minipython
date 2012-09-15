/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import Expr.ExpP;
import type.Tipo;

/**
 *
 * @author uno
 */
public class SimpleLeftValue extends leftValue{
    String Varname;
    
    public SimpleLeftValue(int linea, String Varname)
    {
        this.line=linea;
        this.Varname=Varname;
    }    
    @Override
    public String toString() {
        String str ="Simple left Value";
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

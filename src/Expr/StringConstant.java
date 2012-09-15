/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import type.Tipo;

/**
 *
 * @author uno
 */
public class StringConstant extends Expr{
String value;

public StringConstant(String value, int linea)
{
    this.line=linea;
    this.value=value;
}
    @Override
    public String toString() {
        String str="String constant";
        return str;
        //        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

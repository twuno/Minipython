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
private String value;

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
    public int EvalI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}

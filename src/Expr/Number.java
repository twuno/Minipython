/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import type.IntType;
import type.Tipo;

/**
 *
 * @author uno
 */
public class Number extends Expr {
int Value;

public Number(int linea, int Value)
{
    this.Value=Value;
    this.line=linea;
}
    @Override
    public String toString() {
        String str=Integer.toString(Value);
        return str;
//                throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() {
        IntType entero = new IntType();
        return entero;
    }

    @Override
    public ExpP Eval() throws Exception {
        
        return null;
        
        
    }
    
}

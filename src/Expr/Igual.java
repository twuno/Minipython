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
public class Igual extends BinaryExp{
    Expr exp1, exp2;
    
    public Igual(int linea, Expr exp1, Expr exp2)
    {
 this.exp1=exp1;
       this.exp2=exp2;
              this.line=linea;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
        if(exp1.ValidarSemantica().Equivalente(exp2.ValidarSemantica()))
        {
            return exp1.ValidarSemantica();
        }
        throw new Exception("Comparacion entre distinto tipo de operadores");
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

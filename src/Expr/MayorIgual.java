/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import type.BoolType;
import type.Tipo;

/**
 *
 * @author uno
 */
public class MayorIgual extends BinaryExp{
    Expr exp1, exp2;
    
    public MayorIgual(int linea, Expr exp1, Expr exp2)
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
        BoolType b=new BoolType();
        if(exp1.ValidarSemantica().Equivalente(exp2.ValidarSemantica())){
            return b;
        }else
        {
            throw new Exception("Los tipos evaluados no son equivalente");
        }
    }

    @Override
    public int EvalI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        if(exp1.EvalI()>=exp2.EvalI())
        {
            return true;
        }
        return false;
        //   throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

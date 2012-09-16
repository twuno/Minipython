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
    public int EvalI() throws Exception {
        
           throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
     if(exp1 instanceof Bool)
        {
            if(exp1.EvalB()==exp2.EvalB())
            {
                return true;
            }else 
            {
                return false;
            }
        }else
        {
            if(exp1.EvalI()==exp2.EvalI())
            {
                return true;
            }else
            {
                return false;
            }
        }
    }
    
}

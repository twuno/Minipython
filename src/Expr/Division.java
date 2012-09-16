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
public class Division extends BinaryExp{
    Expr exp1,exp2;
    
     public Division(int linea, Expr exp1, Expr exp2)
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
        IntType i = new IntType();
        if(exp1.ValidarSemantica().Equivalente(exp2.ValidarSemantica())&& exp1.ValidarSemantica().Equivalente(i))
        {
            return i;
        }
        throw new Exception("Esta operacion no soporta esa accion");
        // throw new UnsupportedOperationException("Not supported yet.");
    }

 

    @Override
    public int EvalI() throws Exception {
        if(exp2.EvalI()!=0){
      return(this.exp1.EvalI()/exp2.EvalI());
        }else
        {
            throw new Exception("No se pueden realizar divisiones con denominador cero");
        }
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

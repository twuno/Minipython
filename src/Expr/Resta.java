/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import java.awt.image.RescaleOp;
import type.BoolType;
import type.IntType;
import type.Tipo;

/**
 *
 * @author uno
 */
public class Resta extends BinaryExp {
    Expr exp1,exp2;
    public Resta(int linea, Expr exp1, Expr exp2 )
    {
 this.exp1=exp1;
       this.exp2=exp2;
              this.line=linea;
    }
    @Override
    public String toString() {
            String str="Resta";
        return str;
     
 //       throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
          IntType b=new IntType();
        if(exp1.ValidarSemantica().Equivalente(exp2.ValidarSemantica())&& exp1.ValidarSemantica().Equivalente(b)){
            return b;
        }else
        {
            throw new Exception("Los tipos evaluados no son equivalente");
        }    }


    @Override
    public int EvalI() throws Exception {
        return exp1.EvalI()-exp2.EvalI();
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

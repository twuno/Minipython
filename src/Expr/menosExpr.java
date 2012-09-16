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
public class menosExpr extends UnaryExp{
Expr e;
public menosExpr(int linea, Expr e)
{
    this.e=e;
    this.line=linea;
}
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
             IntType b=new IntType();
        if(e.ValidarSemantica().Equivalente(b)){
            return b;
        }else
        {
            throw new Exception("Los tipos evaluados no son equivalente");
        }
    
    
    }


    @Override
    public int EvalI() throws Exception {
    return(this.e.EvalI()-(this.e.EvalI()*2));
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

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
public class negacion extends UnaryExp{
Expr e;

public negacion(int linea,Expr e)
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
               BoolType b=new BoolType();
        if(e.ValidarSemantica().Equivalente(b)){
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
        return (!this.e.EvalB());
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
}

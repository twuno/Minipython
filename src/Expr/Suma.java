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
public class Suma extends BinaryExp{
Expr exp1, exp2;
    public Suma(int linea, Expr exp1, Expr exp2)
    {
      this.exp1=exp1;
       this.exp2=exp2;
      
        this.line=linea;
    }
    
    @Override
    public String toString() {
        String str="suma";
        return str;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
              IntType b=new IntType();
        if(exp1.ValidarSemantica().Equivalente(exp2.ValidarSemantica())&& exp1.ValidarSemantica().Equivalente(b)){
            return b;
        }else
        {
            throw new Exception("Los tipos evaluados no son equivalente");
        }
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}

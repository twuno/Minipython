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
public class Bool extends Expr{
boolean value;
public Bool(int linea,boolean val)
{
    this.line=linea;
    this.value=val;
}
    
    @Override
    public String toString() {
        String str="Boolean";
        return str;
        //      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() {
        BoolType b= new BoolType();
        return b;
    }

   

    @Override
    public int EvalI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
   return this.value;
           }

    
    
}

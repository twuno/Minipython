/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import java.util.ArrayList;
import type.IntType;
import type.Tipo;

/**
 *
 * @author uno
 */
public class ExpresionCorchetes extends Expr{
    
    private ArrayList<Expr> params;

    public ExpresionCorchetes(ArrayList<Expr> params,int linea)
    {
        this.line=linea;
        this.params=params;
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the params
     */
    public ArrayList<Expr> getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(ArrayList<Expr> params) {
        this.params = params;
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        IntType i = new IntType();
          for(int x=0; x<params.size();x++){
            if(!params.get(x).ValidarSemantica().Equivalente(i))
            {
                throw new Exception("No es soportado un tipo booleano en esta expresion");
            }
            }   
           return i;
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

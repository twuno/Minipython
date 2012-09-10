/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import java.util.ArrayList;

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
    
}

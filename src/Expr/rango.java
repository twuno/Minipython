/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;
import type.IntType;
import type.Tipo;

/**
 *
 * @author uno
 */
public class rango extends BinaryExp{
    private Expr e1;
    private Expr e2;

public rango(int line,Expr e1,Expr e2)
{
    this.e1=e1;
       this.e2=e2;
      
    this.line=line;

}
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the e1
     */
    public ASTNode getE1() {
        return e1;
    }

    /**
     * @param e1 the e1 to set
     */
    public void setE1(Expr e1) {
        this.e1 = e1;
    }

    /**
     * @return the e2
     */
    public ASTNode getE2() {
        return e2;
    }

    /**
     * @param e2 the e2 to set
     */
    public void setE2(Expr e2) {
        this.e2 = e2;
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
              IntType b=new IntType();
        if(!e1.ValidarSemantica().Equivalente(e2.ValidarSemantica())&& e1.ValidarSemantica().Equivalente(b)){
            {
            throw new Exception("Los tipos evaluados no son equivalente");
            }
    }
    return b;
    }



    @Override
    public int EvalI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean EvalB() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

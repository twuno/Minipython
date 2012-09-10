/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import java.awt.image.RescaleOp;

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
    
}

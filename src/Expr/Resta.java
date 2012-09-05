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
    
    public Resta(int linea, Expr val1, Expr val2 )
    {
        super(val1, val2);
        this.line=linea;
    }
    @Override
    public String toString() {
            String str="Resta";
        return str;
     
 //       throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

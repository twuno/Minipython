/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

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
    
    
}

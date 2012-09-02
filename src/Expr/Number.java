/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

/**
 *
 * @author uno
 */
public class Number extends Expr {
int Value;

public Number(int linea, int Value)
{
    this.Value=Value;
    this.line=linea;
}
    @Override
    public String toString() {
        String str="Numero";
        return str;
//                throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

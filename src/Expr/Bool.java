/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

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
    
    
}

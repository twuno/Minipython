/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;


/**
 *
 * @author uno
 */
public class Suma extends BinaryExp{

    public Suma(int linea, Expr val1, Expr val2)
    {
        super(val1, val2);
        this.line=linea;
    }
    
    @Override
    public String toString() {
        String str="suma";
        return str;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

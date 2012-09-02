/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;
import Expr.BinaryExp;

/**
 *
 * @author uno
 */
public class AddBinaryExp extends BinaryExp{

    public AddBinaryExp(int linea, ASTNode val1, ASTNode val2)
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

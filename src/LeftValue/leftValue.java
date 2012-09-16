/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import ASTNODE.ASTNode;
import Expr.Expr;

/**
 *
 * @author uno
 */
public abstract class leftValue extends Expr{
    public abstract String NombreVar();
    public abstract void SetScope(int Scope, leftValue Method);
            
}

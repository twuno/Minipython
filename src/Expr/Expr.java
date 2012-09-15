/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expr;

import ASTNODE.ASTNode;
import type.Tipo;

/**
 *
 * @author uno
 */
public abstract class Expr extends ASTNode {
    public abstract Tipo ValidarSemantica()throws Exception;
        public abstract ExpP Eval()throws Exception;
}

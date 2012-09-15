/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolo;

import Expr.Expr;
import type.Tipo;

/**
 *
 * @author uno
 */
public class Var extends Value {

    public Var() {
    }

    public Var(Tipo tipo, Expr value) {
        this.tipo = tipo;
        this.value = value;
    }
    private Tipo tipo;
    private Expr value;

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the value
     */
    public Expr getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Expr value) {
        this.value = value;
    }

    @Override
    public boolean esEquivalente(Value v) {
        return v instanceof Var;
    }
}

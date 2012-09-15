/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolo;

import LeftValue.leftValue;
import java.util.Hashtable;
import java.util.List;
import type.Tipo;

/**
 *
 * @author uno
 */
public class Funcion extends Value{

    public Funcion(Hashtable<leftValue, Var> parametros, Hashtable<leftValue, Var> minitabla, Tipo retorno) {
        this.parametros = parametros;
        this.minitabla = minitabla;
        this.retorno = retorno;
    }
    private Hashtable<leftValue, Var> parametros;
    private Hashtable<leftValue, Var> minitabla;
    private Tipo retorno;

    /**
     * @return the parametros
     */
    public Hashtable<leftValue, Var> getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(Hashtable<leftValue, Var> parametros) {
        this.parametros = parametros;
    }

    /**
     * @return the minitabla
     */
    public Hashtable<leftValue, Var> getMinitabla() {
        return minitabla;
    }

    /**
     * @param minitabla the minitabla to set
     */
    public void setMinitabla(Hashtable<leftValue, Var> minitabla) {
        this.minitabla = minitabla;
    }

    /**
     * @return the retorno
     */
    public Tipo getRetorno() {
        return retorno;
    }

    /**
     * @param retorno the retorno to set
     */
    public void setRetorno(Tipo retorno) {
        this.retorno = retorno;
    }

    @Override
    public boolean esEquivalente(Value v) {
        return v instanceof Funcion;
    }
}

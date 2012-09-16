/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import Expr.ExpP;
import TablaSimbolo.Funcion;
import TablaSimbolo.Value;
import TablaSimbolo.Var;
import TablaSimbolo.tablasimbolos;
import java.util.Hashtable;
import phyton.semantico;
import type.Tipo;

/**
 *
 * @author uno
 */
public class SimpleLeftValue extends leftValue{
    String Varname;
    leftValue method;
    int Scope;
    public SimpleLeftValue(int linea, String Varname)
    {
        this.line=linea;
        this.Varname=Varname;
    }    
    @Override
    public String toString() {
        String str ="Simple left Value";
        return str;
        //        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo ValidarSemantica() throws Exception {
     //   throw new UnsupportedOperationException("Not supported yet.");
        Value v;
        if(this.Scope==0){
            v=tablasimbolos.getinstance().lookat(Varname);
            if(v==null){
                throw new Exception("La variable " + Varname + "no existe");
            }else{
                if(v instanceof Var)
                {
                    Var v1 = (Var) v;
                    return v1.getTipo();
                }/*if(v instanceof Funcion)
                {
                    Funcion v1 = (Funcion) v;
                    return v1.getRetorno();
                }*/
        
            }
        return null;
        }else if(this.Scope==1)
        {
            Funcion f=(Funcion)tablasimbolos.getinstance().lookat(method);
            Hashtable t=f.getMinitabla();
            if(t.contains(Varname))
            {
                Var v2=(Var)t.get(Varname);
                return v2.getTipo();
            }else
            {
                throw new Exception("Esta Variable aun no ha sido declarada");
            }
        }
                throw new Exception("Nivel de Scope no soportado");
    }

    @Override
    public ExpP Eval() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String NombreVar() {
       return Varname;
    }

    @Override
    public void SetScope(int Scope, leftValue Method) {
        this.Scope=Scope;
        this.method=Method;
    }
    
}

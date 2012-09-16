/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeftValue;

import ASTNODE.ASTNode;
import Expr.Bool;
import Expr.ExpP;
import Expr.Expr;
import Expr.Number;
import TablaSimbolo.Funcion;
import TablaSimbolo.Value;
import TablaSimbolo.Var;
import TablaSimbolo.tablasimbolos;
import java.util.Hashtable;
import type.Tipo;

/**
 *
 * @author uno
 */
public class ArraysIndexLeftValue extends leftValue {
    private String Varname;
    private Expr expr;
    int scope;
    leftValue method;
    public ArraysIndexLeftValue(String Varname, Expr exp)
    {
        this.Varname=Varname;
        this.expr=exp;
        //this.lineak=linea;
        //this.line=linea;
    }
    @Override
    public String toString() {
        String str="Indice pa un Arreglo";
        return str;
        //        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
       public Tipo ValidarSemantica() throws Exception {
     //   throw new UnsupportedOperationException("Not supported yet.");
        Value v;
        if(this.scope==0){
            ArraysIndexLeftValue a=new ArraysIndexLeftValue(getVarname(),(Expr)getExpr());
            v=tablasimbolos.getinstance().lookat(a);
            if(v==null){
                throw new Exception("La variable " + getVarname() +"["+getExpr()+ "] no existe");
            }else{
                if(v instanceof Var)
                {
                    Var v1 = (Var) v;
                    return v1.getTipo();
                }if(v instanceof Funcion)
                {
                    Funcion v1 = (Funcion) v;
                    return v1.getRetorno();
                }
        
            }
        return null;
        }else if(this.scope==1)
        {
            Funcion f=(Funcion)tablasimbolos.getinstance().lookat(method);
            Hashtable t=f.getMinitabla();
            if(t.contains(getVarname()))
            {
                Var v2=(Var)t.get(getVarname());
                return v2.getTipo();
            }else
            {
                throw new Exception("Esta Variable aun no ha sido declarada");
            }
        }
                throw new Exception("Nivel de Scope no soportado");
    }



    @Override
    public String NombreVar() {
        return getVarname();
    }

    @Override
    public void SetScope(int Scope, leftValue Method) {
        this.scope=Scope;
        this.method=Method;
        
    }

    /**
     * @return the Varname
     */
    public String getVarname() {
        return Varname;
    }

    /**
     * @param Varname the Varname to set
     */
    public void setVarname(String Varname) {
        this.Varname = Varname;
    }

    /**
     * @return the expr
     */
    public Expr getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public int EvalI() throws Exception {
        if(this.expr instanceof Number)//Creo ke esto no es lo ke se tiene ke devolver
        {
            return expr.EvalI();
        }
       throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public boolean EvalB() throws Exception {
        if(expr instanceof Bool)
        {
        return expr.EvalB();
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

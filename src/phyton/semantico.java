/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phyton;

import ASTNODE.ASTNode;
import ASTNODE.FieldDeclNode;
import ASTNODE.MethodDeclNode;
import ASTNODE.ProgramNode;
import Expr.Expr;
import LeftValue.leftValue;
import TablaSimbolo.Funcion;
import TablaSimbolo.Value;
import TablaSimbolo.Var;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author uno
 */
public class semantico {
    ASTNode raiz;
    ProgramNode program;
    Hashtable<leftValue, Value> tablasimbolos= new Hashtable<leftValue, Value>();

    public semantico(ASTNode raiz) throws Exception {
        this.raiz = raiz;
        this.program=(ProgramNode)raiz;
        Semanticando();
    }

    private void Semanticando() throws Exception{
        if(!tienemain())
        {
            throw new Exception("No tiene main");
        }
    ArrayList<ASTNode> listfd=  program.getField_decl_list();    
    for(int x=0; x<listfd.size();x++)
    {
        FieldDeclNode fd = (FieldDeclNode)listfd.get(x);
        leftValue lv = (leftValue)fd.getVarName();
        Expr e=(Expr)fd.getRight();        
        Value vl = new Var(e.ValidarSemantica(),e);
        add(lv, vl);
    }
  ArrayList<ASTNode> listmd=  program.getMethod_decl_list();    
    for(int x=0; x<listfd.size();x++)
    {
        FieldDeclNode fd = (FieldDeclNode)listfd.get(x);
        leftValue lv = (leftValue)fd.getVarName();
        Expr e=(Expr)fd.getRight();        
        Value vl = new Var(e.ValidarSemantica(),e);
        add(lv, vl);
    }
    }
    
    public void add(leftValue lv, Value val) throws Exception
    {
        Value v= tablasimbolos.get(lv);
        if(v==null){
        this.tablasimbolos.put(lv, val);
        }else
        {
            if(v.esEquivalente(val))
            {
                if(v instanceof Var)
                {
                    Var v1=(Var)v;
                    Var v2=(Var)val;
                    
                    if(v1.getTipo().Equivalente(v2.getTipo()))
                    {
                        tablasimbolos.remove(lv);
                        tablasimbolos.put(lv, val);
                    }else
                    {
                        throw new Exception("No puede cambiar el tipo de esta variable");
                    }
                }else if(v instanceof Funcion)
                {
                              throw new Exception("No Puede sobre cargar esta funcion");
                }
            }else
            {
                throw new Exception("no se puede declarar una funcion con el nombre de una variable");
            }
        }
    }
    
    
    public boolean tienemain()
    {
            ArrayList<ASTNode> list;
            list= program.getMethod_decl_list();
        for(int x =0; x<list.size();x++)
        {

            MethodDeclNode md = (MethodDeclNode)list.get(x);  
            if(md.getMethodName().compareToIgnoreCase("main")==0){
            return true;
            }
        }
    return false;
    }
}


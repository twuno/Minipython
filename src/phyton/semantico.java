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
import TablaSimbolo.tablasimbolos;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author uno
 */
public class semantico {
    ASTNode raiz;
    ProgramNode program;
    

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
        tablasimbolos.getinstance().add(lv, vl);
    }
    Value va=tablasimbolos.getinstance().lookat("a");
  ArrayList<ASTNode> listmd=  program.getMethod_decl_list();    
    for(int x=0; x<listmd.size();x++)
    {
        MethodDeclNode md = (MethodDeclNode)listmd.get(x);
        leftValue Nombre = md.getMethodName();
       /*
        Expr e=(Expr)fd.getRight();        
   */
       Funcion fn = new Funcion(null, null, null);
        tablasimbolos.getinstance().add(Nombre, fn);
   
        
    }
    }
    
    public Hashtable llenarParametros(leftValue Methodname)// aun no lo termino
    {
        Hashtable<leftValue,Var> parametros = new Hashtable<leftValue, Var>();
         ArrayList<ASTNode> listmd=  program.getMethod_decl_list();
           for(int x=0; x<listmd.size();x++)
            {
                 MethodDeclNode md = (MethodDeclNode)listmd.get(x);    
                 if(md.getMethodName().NombreVar().compareToIgnoreCase(Methodname.NombreVar())==0)
                 {
                     md.getArguments();
                 }
            }
        
        
        return parametros;
    } 
   
    
    public boolean tienemain()
    {
            ArrayList<ASTNode> list;
            list= program.getMethod_decl_list();
        for(int x =0; x<list.size();x++)
        {

            MethodDeclNode md = (MethodDeclNode)list.get(x);  
            if(md.getMethodName().NombreVar().compareToIgnoreCase("main")==0){
            return true;
            }
        }
    return false;
    }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolo;

import LeftValue.ArraysIndexLeftValue;
import LeftValue.leftValue;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author uno
 */
public class tablasimbolos {

    public static tablasimbolos getinstance() {
        if(instance==null)
            {
               instance = new tablasimbolos();
        }
        return instance;
    }

private tablasimbolos() {
    }
Hashtable<leftValue, Value> tablasimbolos= new Hashtable<leftValue, Value>();   



    static tablasimbolos instance = null;

     public Value lookat(String nombre)
    {
     
       Enumeration<leftValue> tmp;
             tmp= tablasimbolos.keys();
             for (Map.Entry<leftValue, Value> entry : tablasimbolos.entrySet()) {
            leftValue value = entry.getKey();
            Value value1 = entry.getValue();
                 if (value.NombreVar().equalsIgnoreCase(nombre))
                 {
                     return value1;
                 }
            }
             
             return null;
    }
 public Value lookat(leftValue nombre)
    {
  //  return this.tablasimbolos.get(nombre);
    if(nombre instanceof ArraysIndexLeftValue)
    {
        ArraysIndexLeftValue arr = (ArraysIndexLeftValue) nombre;
    Enumeration<leftValue> enu;
    enu=tablasimbolos.keys();
    for(Map.Entry<leftValue,Value> entry : tablasimbolos.entrySet())
    {   
            
        leftValue value = entry.getKey();
        if(value instanceof ArraysIndexLeftValue){
            ArraysIndexLeftValue value2=(ArraysIndexLeftValue)value;
            Value value1 = entry.getValue();
        if(value2.NombreVar().equalsIgnoreCase(arr.NombreVar()) && value2.getExpr()==arr.getExpr())
    
                return value1;
    
        }
    }
   
    }
     return null;
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
    
    
    
}

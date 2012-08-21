/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phyton;

import java.awt.LinearGradientPaint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Stack;

/**
 *
 * @author uno
 */
public class lexer {
    Hashtable<String,Integer> palres=new Hashtable<String, Integer>();
    Hashtable<String,Integer> Symbol=new Hashtable<String, Integer>();
    private InputStream in;
   private int linea=1;
 Stack<Integer>pila= new Stack<Integer>();
    boolean cola=false;
   boolean primeralinea=true;
    boolean enter=false;
    int espacios=0;
     int estados;
     boolean inicio;
   boolean fda;
     public lexer()
    {
        in=null;
        Palabras();

   }

    public lexer(InputStream in)
     {
        this.in=in;
        Palabras();
        pila.push(0);
        estados=0;  
        inicio=true;
        fda=false;
        espacios=0;
    }

    private void Palabras() {
     Symbol.put("+",token.OP_SUM);
     Symbol.put("-",token.OP_RESTA);
     Symbol.put("*",token.OP_MULTIPLICACION);
     Symbol.put("/",token.OP_DIVISION);
     Symbol.put("%",token.OP_MOD);
     Symbol.put(",",token.SIG_COMA);
     Symbol.put(":",token.SIG_DP);
     Symbol.put("(",token.SIG_PARIZ);
     Symbol.put(")",token.SIG_PARDE);
     Symbol.put("[",token.SIG_CORCHETEIZ);
     Symbol.put("]",token.SIG_CORCHETEDER);
     Symbol.put("~",token.SIG_NEGACION);
     palres.put("break",token.KW_BREAK);
     palres.put("while",token.KW_WHILE);
     palres.put("and",token.OP_AND);
     palres.put("or",token.OP_OR);
     palres.put("not",token.OP_NOT);
     palres.put("true",token.KW_TRUE);
     palres.put("false",token.KW_FALSE);
     palres.put("class",token.KW_CLASS);
     palres.put("ID",token.KW_ID);
     palres.put("def",token.KW_DEF);
     palres.put("if",token.KW_IF);
     palres.put("elif",token.KW_ELIF);
     palres.put("else",token.KW_ELSE);
     palres.put("for",token.KW_FOR);
     palres.put("in",token.KW_IN);
     palres.put("return",token.KW_RETURN);
     palres.put("print",token.KW_PRINT);


    }
    public token getNextToken() throws IOException, Exception
    {
        StringBuilder content = new StringBuilder();
        int nextByte;
        in.mark(10);
        nextByte=in.read();

        if(cola)
        {
         estados=16;
         in.reset();
        }
        else if(inicio)
        {
         estados=15;
         in.reset();
        }else if(fda)
        {
        in.reset();
        }
        else{
            estados=0;

        }
        while(true)
        {
           
             if(nextByte==-1 && pila.peek()==0)
             {
                return new token(token.EOF,"$");
             }else if(nextByte==-1 && pila.peek()>0)
             {
             pila.pop();
             return new token(token.V_DDENT,"dd");
             }
             switch(estados){
             
                 case 0:
                      if(Character.isLetter(nextByte) || nextByte=='_')
                      {
                            content.append((char)nextByte);
                            estados=1;
                            inicio=false;
                      }else if(Character.isDigit(nextByte))
                      {
                            content.append((char)nextByte);
                            estados=2;
                            inicio=false;
                      }else if(nextByte=='+' || nextByte=='-' || nextByte=='*' || nextByte=='/' ||
                               nextByte=='%' || nextByte==',' || nextByte=='[' || nextByte==']' ||
                               nextByte=='(' || nextByte==')' || nextByte=='~' || nextByte==':')
                      {
                          content.append((char)nextByte);
                          estados=3;
                          inicio=false;
                      }else if(nextByte=='=')
                      {
                        content.append((char)nextByte);
                        estados=4;
                        inicio=false;
                      }else if(nextByte=='<')
                      {
                          content.append((char)nextByte);
                          estados = 8;
                          inicio=false;
                      }else if(nextByte=='>')
                      {
                            estados = 9;
                            inicio=false;
                      }else if(nextByte=='!')
                      {
                            estados = 10;
                            inicio=false;
                      }else if(nextByte=='.')
                      {
                            estados = 11;
                            inicio=false;
                      }
                      else if(nextByte=='\n' || nextByte=='\r' )
                      {     primeralinea=false;
                            linea++;
                            estados=15;
                            inicio=true;
                            espacios=0;
                             return new token(token.DELIMITADOR_NL,"NL");
                     
                      }else if(nextByte=='\t' && inicio==true)
                      {
                            estados=15;
                            inicio=false;
                            espacios=espacios+4;
                      }else if(nextByte==' ' && inicio==true)
                      {
                        estados=15;
                        inicio=false;
                        espacios=espacios+1;

                      }else if((nextByte=='\t'||nextByte==' ')&& inicio==false)
                      {
                            nextByte=in.read();
                          continue;
                      }else if(nextByte=='#')
                      {
                        do
                        {
                            in.mark(2);
                            nextByte=in.read();
                            continue;
                        }while(nextByte!='\n');
                     //return new token(token.OP_COMENTARIO, "#");

                      }else if(nextByte=='"')
                      {
                           content.append((char)nextByte);
                            estados=5;
                            inicio=false;
                      }
                      else if(nextByte=='\'')
                      {
                           content.append((char)nextByte);
                            estados=6;
                            inicio=false;
                      }
                 break;

                 case 1:
                        in.mark(10);
                        nextByte=in.read();
             
                        while(nextByte=='_' || Character.isDigit(nextByte) || Character.isLetter(nextByte))
                        {
                                content.append((char)nextByte);
                                in.mark(10);
                                nextByte = in.read();
                        }
                         in.reset();
                           if(existe(content.toString()))
                            {
                                 return new token(palres.get(content.toString()), content.toString());
                            }else
                            {
                               return new token(token.KW_ID,content.toString());
                             }

                 case 2:
                        in.mark(10);
                        nextByte=in.read();
                        while(Character.isDigit(nextByte))
                        {
                                content.append((char)nextByte);
                                in.mark(10);
                                nextByte = in.read();
                        }
                         in.reset();
                         return new token(token.LIT_NUM,content.toString());

                 case 3:
                     return new token(Symbol.get(content.toString()),content.toString());

                 case 4:
                     in.mark(10);
                     nextByte=in.read();

                     if(nextByte=='=')
                     {
                        return new token(token.OP_COMPARACION,"==");
                     }else
                     {
                        in.reset();
                        return new token(token.SIG_ASIGNACION, "=");
                     }
                 case 5:

                         in.mark(10);
                        nextByte=in.read();

                        while(nextByte!='"')
                        {
                                content.append((char)nextByte);
                                in.mark(10);
                                nextByte = in.read();
                        }
                            content.append((char)nextByte);
                        //    nextByte=in.read();
                     //    in.reset();
                        estados=0;
                                 return new token(token.LIT_CHCONST, content.toString());
                        
                 case 6: 
                     
                         in.mark(10);
                        nextByte=in.read();
             
                        while(nextByte!='\'')
                        {
                                content.append((char)nextByte);
                                in.mark(10);
                                nextByte = in.read();
                        }
                               content.append((char)nextByte);
                               estados=0;
                               //  in.reset();
                                 return new token(token.LIT_CHCONST, content.toString());
                       
                 case 8:
                     in.mark(2);
                     nextByte=in.read();
                     if(nextByte=='=')
                     {
                        return new token(token.OP_MENORIGUAL, "<=");
                     }else if(nextByte=='<')
                     {
                        return new token(token.OP_SHIFTLEFT,"<<");
                     }
                         in.reset();
                         return new token(token.OP_MENOR,"<");

                 case 9:
                       in.mark(2);
                     nextByte=in.read();
                     if(nextByte=='=')
                     {
                        return new token(token.OP_MAYORIGUAL, ">=");
                     }else if(nextByte=='>')
                     {
                        return new token(token.OP_SHIFTRIGHT,">>");
                     }
                         in.reset();
                         return new token(token.OP_MAYOR,">");

                 case 10:
                     in.mark(2);
                     nextByte=in.read();

                     if(nextByte=='=')
                     {
                        return new token(token.SIG_NEGACION, "!=");
                     }

                   break;

                 case 11:
                        in.mark(2);
                        nextByte=in.read();
                        if(nextByte=='.')
                        {
                            estados=12;
                        }

                 case 12:
                        in.mark(2);
                        nextByte=in.read();
                        if(nextByte=='.')
                        {
                            return new token(token.SIG_RANGO,"...");
                        }

                 case 15:
                         in.mark(100);
                         nextByte=in.read();
                        if(nextByte=='\t')
                         {
                             espacios=4;
                             in.mark(10);
                             nextByte=in.read();
                            while(nextByte=='\t')
                            {
                                espacios+=4;
                                in.mark(10);
                                nextByte=in.read();
                            }
                              if(nextByte=='\n')
                                {
                                    linea++;
                                    estados=0;
                                    inicio=true;
                                    //nextByte=in.read();
                                    break;
                                }
                            in.reset();
                            inicio=false;
                            estados=16;
                        }else if(nextByte==' ')
                        {
                            espacios+=1;
                            in.mark(10);
                            nextByte=in.read();
                            while(nextByte==' ')
                                {
                                    espacios+=1;
                                    in.mark(10);
                                    nextByte=in.read();
                                
                                }
                                if(nextByte=='\n')
                                {
                                    inicio=true;
                                   linea++;
                                    estados=0;
                                   // nextByte=in.read();
                                    break;
                                }
                            in.reset();
                            inicio=false;
                            estados=16;
                        }else if(nextByte=='\n')
                        {
                        //    nextByte=in.read();
                            estados=15;
                            inicio=true;
                            espacios=0;
                            linea++;
                        }else if(nextByte=='#')
                        {
                            do{
                            nextByte=in.read();
                            in.mark(10);
                            }while(nextByte!='\n');
                            linea++;
                            estados=15;
                            inicio=true;
                        }
                        
                        else{
                           in.reset();
                            enter=false;
                            estados=16;
                            espacios =0;
                        }
                        break;
                 case 16:
                   if(pila.peek()<espacios && cola==false)
                   {
                        pila.push(espacios);
                        return new token(token.V_IDNT,Integer.toString(espacios));
                   }else if(pila.peek()>espacios)
                   {
                        pila.pop();
                        cola=true;
                        in.reset();
                        return new token(token.V_DDENT, "DDENT");

                   } if(pila.peek()<espacios && cola==true )
                       {
                           throw new Exception("Error de indentacion " + linea);
                       }else if(pila.peek()==espacios && espacios==0 && primeralinea==false)
                       {
                            throw new Exception("Error con indent "+ linea );
                       }

                    else if(pila.peek()==espacios ){
                   cola=false;
                   espacios=0;
                   estados=0;
                   nextByte=in.read();
                    }
                }
             }
             }
            

        
    

    private boolean existe(String identifier) {
        if(palres.get(identifier)!=null)
        {
            return true;
        }
        return false;
    }

    public int getlinea()
    {
        return linea;
    }

}

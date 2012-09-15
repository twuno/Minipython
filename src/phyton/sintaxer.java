package phyton;
import ASTNODE.*;
import Expr.And;
import Expr.BinaryExp;
import Expr.Bool;
import Expr.Distinto;
import Expr.Division;
import Expr.ExpP;
import Expr.Expr;
import Expr.ExpresionCorchetes;
import Expr.Igual;
import Expr.Number;
import Expr.LeftValueExpr;
import Expr.MayorIgual;
import Expr.MayorQue;
import Expr.MenorIgual;
import Expr.MenorQue;
import Expr.MethodCallExpr;
import Expr.Multiplicacion;
import Expr.Not;
import Expr.Or;
import Expr.Resta;
import Expr.ShiftLeft;
import Expr.ShiftRight;
import Expr.StringConstant;
import Expr.Suma;
import Expr.UnaryExp;
import Expr.menosExpr;
import Expr.mod;
import Expr.negacion;
import Expr.rango;
import LeftValue.ArraysIndexLeftValue;
import LeftValue.SimpleLeftValue;
import LeftValue.leftValue;
import Statement.AssignStatement;
import Statement.Break;
import Statement.ForStatement;
import Statement.IfStatement;
import Statement.MethodCall;
import Statement.ReturnStatement;
import Statement.While;
import Statement.statement;
import com.sun.org.apache.xpath.internal.operations.Mod;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uno
 */
public class sintaxer {

    InputStream in;
    lexer lex;
    token currentToken;
    ASTNode node;
    public sintaxer()
    {
        in=null;
    }
    public sintaxer(InputStream in) throws IOException, Exception
    {
        this.in=in;
        lex=new lexer(in);
        try {
            currentToken = lex.getNextToken();
        } catch (Exception ex) {
            Logger.getLogger(sintaxer.class.getName()).log(Level.SEVERE, null, ex);
        }
       node= program();

    }

    private ProgramNode program() throws IOException, Exception
    {
        int linea =lex.getlinea();
      ProgramNode pm;
      match(token.KW_CLASS);
      String id;
     // match(token.KW_ID);
      if(currentToken.getType()==token.KW_ID)
      {
          id=currentToken.getLexema();
          currentToken=lex.getNextToken();
      }else
      {
          throw new Exception("Se esperaba un token ID");
      }
      match(token.SIG_DP);
      match(token.DELIMITADOR_NL);
       InicioBloque();
       ArrayList<ASTNode> fdecl = new ArrayList<ASTNode>();
          ArrayList<ASTNode> mdecl=new ArrayList<ASTNode>();
       while(currentToken.getType()==token.KW_ID)
      {
        fdecl.add(field_decl());
      }
      
      while(currentToken.getType()==token.KW_DEF)
      {
        mdecl.add(method_decl());
      }
      FinBloque();
      pm=new ProgramNode(linea, id, fdecl, mdecl);
      return pm;
    }

    private FieldDeclNode field_decl() throws IOException, Exception
    {
         FieldDeclNode fd;
         String id;
         int linea =lex.getlinea();
             //        match(token.KW_ID);
         if(currentToken.getType()==token.KW_ID)
         {
                  
             id=currentToken.getLexema();
             currentToken=lex.getNextToken();
                 Assign right;
                 right=assign(id);
                 fd=new FieldDeclNode(linea,right.getLval(), right.getRval2());
         }else
         {
          throw new Exception("Se esperaba un token ID");
         }
   
         match(token.DELIMITADOR_NL);
         return fd;
    }

    private MethodDeclNode method_decl() throws Exception
    {
        MethodDeclNode md;
        String id=null;
        ArrayList<String> param = new ArrayList<String>();
        BlockNode bl;
        int pos = lex.getlinea();
        SimpleLeftValue slv;
        match(token.KW_DEF);
        //match(token.KW_ID);
        if (currentToken.getType()==token.KW_ID)
        {
        id = currentToken.getLexema();
        slv= new SimpleLeftValue(pos, id);
        currentToken=lex.getNextToken();
        }else
        {
            throw new Exception("Se eseraa un id");
        }
        if(currentToken.getType()==token.SIG_PARIZ){
            match(token.SIG_PARIZ);
            if(currentToken.getType()==token.KW_ID){
  //          match(token.KW_ID);
               param.add(currentToken.getLexema()); 
               currentToken=lex.getNextToken();
            }else
            {
                throw new Exception("Se eseraa un id");
            }
           while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
//                match(token.KW_ID);
                if(currentToken.getType()==token.KW_ID)
                {
                param.add(currentToken.getLexema());    
                currentToken=lex.getNextToken();
                }else{
                  
                  throw new Exception("Se eseraa un id");
                }
            }
         match(token.SIG_PARDE);
        }       
        match(token.SIG_DP);
       bl= block();
       md=new MethodDeclNode(lex.getlinea(), slv, param, bl);
       return md;
    }

    private Assign assign(String id) throws IOException, Exception
    {
        Assign ret;
        Expr lval=lvalue(id);
        match(token.SIG_ASIGNACION);
        Expr rval= expr();
        
        ret=new Assign(lex.getlinea(), lval, rval);
    return ret;
    }

    private BlockNode block() throws Exception
    {
        BlockNode bn;
        ArrayList<ASTNode> statemnt = new ArrayList<ASTNode>();
        match(token.DELIMITADOR_NL);
        InicioBloque();
        do{
        statemnt.add(statement());
        matchE(token.DELIMITADOR_NL);
        }while(isStatement());
        FinBloque();
        bn=new BlockNode(lex.getlinea(), statemnt);
        return bn;
    }

    private statement statement() throws Exception
    {
    if(currentToken.getType()==token.KW_ID)
    {
        return statementP();
    }else if(currentToken.getType()==token.KW_PRINT || currentToken.getType()==token.KW_READ)
    {
        return method_call();
    }else if(currentToken.getType()==token.KW_IF)
    {
        IfStatement is;
        ASTNode ex, ifblock, elseblock=null;
        ArrayList<ASTNode> elif=new ArrayList<ASTNode>();
        match(token.KW_IF);
        ex=expr();
        match(token.SIG_DP);
        ifblock=block();
        while(currentToken.getType()==token.KW_ELIF)
        {ASTNode exe, blocke;
            IfStatement ie;
            match(token.KW_ELIF);
            exe=expr();
            match(token.SIG_DP);
            blocke=block();
            ie=new IfStatement(exe, ifblock, null, null, lex.getlinea());
            elif.add(ie);
        }
        if(currentToken.getType()==token.KW_ELSE)
        {
            match(token.KW_ELSE);
            match(token.SIG_DP);
          elseblock=block();
        }
        is=new IfStatement(ex, ifblock, elif, elseblock, lex.getlinea());
        return is;
    }else if(currentToken.getType()==token.KW_WHILE)
    { int pos =lex.getlinea();
        ASTNode ex, bl;
        match(token.KW_WHILE);
        ex=expr();
        match(token.SIG_DP);
        bl=block();
        While w= new While(pos, ex, bl);
        return w;
    }else if(currentToken.getType()==token.KW_FOR)
    {
        int pos = lex.getlinea();
        String id=null;
        rango r;
        ASTNode bl;
        match(token.KW_FOR);
        if(currentToken.getType()==token.KW_ID)
        {
            id= currentToken.getLexema();
            currentToken=lex.getNextToken();
        }else{throw new Exception("Se esperaba id en el for");}
        //match(token.KW_ID);
        match(token.KW_IN);
        r=range();
        match(token.SIG_DP);
        bl=block();
    ForStatement f = new ForStatement(pos,id,r.getE1(),r.getE2(),bl);
    return f;
    }else if(currentToken.getType()==token.KW_RETURN)
    {
        ReturnStatement r;
        ASTNode a;
        match(token.KW_RETURN);
        a=expr();
        r=new ReturnStatement(lex.getlinea(), a);
        return r;
    }else if(currentToken.getType()==token.KW_BREAK)
    {
        match(token.KW_BREAK);
        Break b=new Break(lex.getlinea());
        return b;
    }else
    {
        throw new Exception("Se esperaba un statement");
    }
    }

    private MethodCall method_call() throws Exception
    {
        int pos =lex.getlinea();
        MethodCall mc; 
        ArrayList<ASTNode> param=new ArrayList<ASTNode>();
    if(currentToken.getType()==token.KW_PRINT)
    {
        match(token.KW_PRINT);
        param.add(expr());
        while(currentToken.getType()==token.SIG_COMA)
        {
            currentToken=lex.getNextToken();
            param.add(expr());
        }
        mc= new MethodCall(pos,"print",param);
    }else if(currentToken.getType()==token.KW_READ)
    {
        match(token.KW_READ);
       //match(token.KW_ID);
            if(currentToken.getType()==token.KW_ID){
               String id=currentToken.getLexema();
                param.add(lvalue(id));//to do hace ke lvalue reciba el nombre y hacer el retorno..
                currentToken=lex.getNextToken();
            }else
            {
                        throw new Exception("Se esperaba un id");
            }
            mc= new MethodCall(pos,"read", param);
    }else
    {
        throw new Exception("Se esperaba una llamada a un metodo");
    }
    return mc;
    }

    private leftValue lvalue(String id) throws IOException, Exception
    {
        leftValue ast;
        if(currentToken.getType()==token.SIG_CORCHETEIZ)
        {
            match(token.SIG_CORCHETEIZ);
             ast=new ArraysIndexLeftValue(lex.getlinea(),id,expr());
            match(token.SIG_CORCHETEDER);
            return ast;
        }
        ast =new SimpleLeftValue(lex.getlinea(), id);
        return ast;
    }

    private Expr expr() throws IOException, Exception
    {
        
    if (currentToken.getType()==token.KW_ID)
    {
        Expr a =ambas();
       Expr p= new ExpP(exprP(a));
       return p;
    }else if(currentToken.getType()== token.LIT_CHCONST || currentToken.getType()== token.LIT_NUM
            ||currentToken.getType()== token.KW_TRUE || currentToken.getType()== token.KW_FALSE)
    {
        
        Expr a =constant();
        
        return exprP(a);
    }else if(currentToken.getType()==token.OP_RESTA)
    {
        menosExpr me;
        Expr e;
        match(token.OP_RESTA);
            
        e=expr();
        me=new menosExpr(lex.getlinea(), e);
        
        return exprP(me);
    }else if(currentToken.getType()==token.SIG_NEGACION)
    {
        negacion ne;
        Expr e;
        match(token.SIG_NEGACION);
        e=expr();
        ne=new negacion(lex.getlinea(), e);    
        return exprP(ne);
    }else if(currentToken.getType()==token.SIG_PARIZ)
    {
        match(token.SIG_PARIZ);
       Expr e= expr();
        match(token.SIG_PARDE);
        return exprP(e);
    }else if(currentToken.getType()==token.SIG_CORCHETEIZ)
    {
        
        match(token.SIG_CORCHETEIZ);
        ExpresionCorchetes Ex;
        ArrayList<Expr> par=new ArrayList<Expr>();
        par.add(expr());
         while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
                par.add(expr());
            }
        match(token.SIG_CORCHETEDER);
        Ex=new ExpresionCorchetes(par, lex.getlinea());
       return exprP(Ex);
    }else
    {
        throw new Exception("se esperaba una expresion");
    }
    }
    private Expr ambas() throws Exception
    {
        
        //match(token.KW_ID);
        String id=null;
        if(currentToken.getType()==token.KW_ID)
        {
            id=currentToken.getLexema();
            currentToken=lex.getNextToken();
        }else
        {
            throw new Exception("Se esperaba un ID");
        }
        return ambasP(id);
           
    }
    private ArrayList<ASTNode> method_ret() throws Exception
    {
        ArrayList<ASTNode> param = new ArrayList<ASTNode>();
        match(token.SIG_PARIZ);
        if(isExpr())
        {
       //     currentToken=lex.getNextToken();
           param.add(expr());
          while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
                param.add(expr());
            }
        }
        match(token.SIG_PARDE);
        return param;
    }

    private Expr exprP(Expr left) throws IOException, Exception
    {
        int pos= lex.getlinea();
        if(currentToken.getType()==token.OP_SUM)
        {
            op_bin();
            Expr r=expr();
            Suma s = new Suma(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_RESTA)
        {
                op_bin();
            Expr r=expr();
            Resta s = new Resta(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_MULTIPLICACION)
        {
            op_bin();
            Expr r=expr();
            Multiplicacion s = new Multiplicacion(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_DIVISION)
        {
            op_bin();
            Expr r=expr();
            Division s = new Division(pos,left,r);
            return s;
        } else if(currentToken.getType()==token.OP_MOD)
        {
            op_bin();
            Expr r=expr();
            mod s = new mod(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_SHIFTLEFT)
        {
            op_bin();
            Expr r=expr();
            ShiftLeft s = new ShiftLeft(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_SHIFTRIGHT)
        {
           op_bin();
            Expr r=expr();
            ShiftRight s = new ShiftRight(pos,left,r);
            return s;
        }else if( currentToken.getType()==token.OP_MENOR)
        {
           op_bin();
            Expr r=expr();
            MenorQue s = new MenorQue(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_MENORIGUAL)
        {
            op_bin();
            Expr r=expr();
            MenorIgual s = new MenorIgual(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_MAYOR)
        {
            op_bin();
            Expr r=expr();
            MayorQue s = new MayorQue(pos,left,r);
            return s;        
        }else if(currentToken.getType()==token.OP_MAYORIGUAL)
        {
            op_bin();
            Expr r=expr();
            MayorIgual s = new MayorIgual(pos,left,r);
            return s;            
        }else if(currentToken.getType()==token.OP_COMPARACION)
        {
            op_bin();
            Expr r=expr();
            Igual s = new Igual(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_DESIGUAL)
        {
                op_bin();
            Expr r=expr();
            Distinto s = new Distinto(pos,left,r);
            return s;
        
        }else if( currentToken.getType()==token.OP_AND)
        {
                op_bin();
            Expr r=expr();
            And s = new And(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_OR)
        {
            op_bin();
            Expr r=expr();
            Or s = new Or(pos,left,r);
            return s;
        }else if(currentToken.getType()==token.OP_NOT)
        {
            op_bin();
            Expr r=expr();
            Not s = new Not(pos,left,r);
            return s;

        }
        return left;
    }

    private void InicioBloque() throws Exception
    {
        match(token.V_IDNT);
    }

    private void FinBloque() throws Exception
    {
        match(token.V_DDENT);
    }

    private rango range() throws Exception
    {
            rango BE;  
            Expr e1,e2;  
            e1=expr();
            match(token.SIG_RANGO);
            e2=expr();
            BE=new rango(lex.getlinea(), e1, e2);
        return BE;
    }

    private void op_bin() throws Exception
    {
        if(currentToken.getType()==token.OP_SUM ||currentToken.getType()==token.OP_RESTA ||
           currentToken.getType()==token.OP_MULTIPLICACION || currentToken.getType()==token.OP_DIVISION ||
           currentToken.getType()==token.OP_MOD || currentToken.getType()==token.OP_SHIFTLEFT ||
           currentToken.getType()==token.OP_SHIFTRIGHT)
        {
           arith_op();
        }else if(currentToken.getType()==token.OP_MENOR ||
           currentToken.getType()==token.OP_MENORIGUAL || currentToken.getType()==token.OP_MAYOR ||
           currentToken.getType()==token.OP_MAYORIGUAL)
        {

            rel_op();
        }else if(currentToken.getType()==token.OP_COMPARACION ||
           currentToken.getType()==token.OP_DESIGUAL)
        {
            eq_op();
        }else if(currentToken.getType()==token.OP_AND ||
           currentToken.getType()==token.OP_OR || currentToken.getType()==token.OP_NOT)
        {
            cond_op();
        }else
        {
            throw new Exception("se esperaba un operador Binario");
        }
    }

    private void arith_op() throws Exception
    {
        if(currentToken.getType()==token.OP_SUM ||currentToken.getType()==token.OP_RESTA ||
           currentToken.getType()==token.OP_MULTIPLICACION || currentToken.getType()==token.OP_DIVISION ||
           currentToken.getType()==token.OP_MOD || currentToken.getType()==token.OP_SHIFTLEFT ||
           currentToken.getType()==token.OP_SHIFTRIGHT)
        {
            currentToken=lex.getNextToken();
        }else
        {
            throw new Exception("Se esperaba un operador aritmetico");
        }
    }

    private void rel_op() throws Exception
    {
        if(currentToken.getType()==token.OP_MENOR ||
           currentToken.getType()==token.OP_MENORIGUAL || currentToken.getType()==token.OP_MAYOR ||
           currentToken.getType()==token.OP_MAYORIGUAL)
        {
            currentToken=lex.getNextToken();
        }else
        {
            throw new Exception("Se esperaba un Operador Relacional");
        }
    }

    private void eq_op() throws Exception
    {
    if(currentToken.getType()==token.OP_COMPARACION ||
           currentToken.getType()==token.OP_DESIGUAL)
    {
        currentToken=lex.getNextToken();
    }else
    {
        throw new Exception("Se esperaba un operador de igual");
    }
    }

    private void cond_op() throws Exception
    {
        if(currentToken.getType()==token.OP_AND ||
           currentToken.getType()==token.OP_OR || currentToken.getType()==token.OP_NOT)
           {
        currentToken=lex.getNextToken();
    }else
    {
        throw new Exception("Se esperaba un operador Condicional");
    }
    }

    private Expr constant() throws Exception
    {
        int pos = lex.getlinea();
        String id=null;
        if(currentToken.getType()==token.LIT_CHCONST)
        {
            id=currentToken.getLexema();
             currentToken = lex.getNextToken();
             StringConstant st =new StringConstant(id, pos);
             return st;
        }else if(currentToken.getType()==token.LIT_NUM)
        {
             int ide;
                    ide =Integer.parseInt(currentToken.getLexema());
             currentToken = lex.getNextToken();
             Number st =new Number(pos,ide);
           return st;
        }else if(currentToken.getType()==token.KW_FALSE || currentToken.getType()==token.KW_TRUE)
        {
            return bool_const();
        }else
        {
            throw new Exception("Se esperaba un constant " +lex.getlinea());
        }
    }

    private Bool bool_const() throws Exception
    {
        int pos=lex.getlinea();
        if(currentToken.getType()==token.KW_FALSE)
        {
             currentToken=lex.getNextToken();
            Bool bool = new Bool(pos, false);
            return bool;
        }if(currentToken.getType()==token.KW_TRUE)
        {
            currentToken=lex.getNextToken();
            Bool bool = new Bool(pos, false);
            return bool;
        }else
        {
            throw new Exception("Se esperaba un valor Booleano");
        }
    }

    private void match(int token) throws IOException, Exception
    {
     if(currentToken.getType()==token)
     {
         currentToken=lex.getNextToken();
     }   else
     {
        token token2=new token();
        String tipoE =token2.NombreToken(token);
        throw new Exception("Se esperaba un token de tipo "+ tipoE + "en la linea "+ lex.getlinea() +" y se recibio un "+token2.NombreToken(currentToken.getType()));
     }
    }
    private void matchE(int token) throws IOException, Exception
    {
     if(currentToken.getType()==token)
     {
        currentToken=lex.getNextToken();
     }
    }

    private boolean  isStatement()
    {
           if(currentToken.getType()==token.KW_ID ||currentToken.getType()==token.KW_PRINT ||
           currentToken.getType()==token.KW_READ || currentToken.getType()==token.KW_IF ||
           currentToken.getType()==token.KW_WHILE || currentToken.getType()==token.KW_FOR ||
           currentToken.getType()==token.KW_RETURN|| currentToken.getType()==token.KW_BREAK) {
           return true;
           }
           return false;

    }

    private boolean isExpr()
    {
         if(currentToken.getType()==token.KW_ID ||currentToken.getType()==token.LIT_NUM ||
           currentToken.getType()==token.LIT_CHCONST || currentToken.getType()==token.KW_TRUE ||
           currentToken.getType()==token.KW_FALSE || currentToken.getType()==token.OP_RESTA ||
           currentToken.getType()==token.SIG_NEGACION|| currentToken.getType()==token.SIG_PARIZ ||
           currentToken.getType()==token.SIG_CORCHETEIZ) {
           return true;
           }
           return false;
    }
    private Expr ambasP(String name) throws Exception
    {
      int pos=lex.getlinea();
        if(currentToken.getType()==token.SIG_PARIZ)
        {
            
             MethodCallExpr mc = new MethodCallExpr(pos, name,method_ret());
             return mc;
        }else
        {

            Expr e = lvalue(name);
//            LeftValue r = new LeftValueExpr(pos, e);
            return e;
        }

    }

    private statement statementP() throws Exception
    {
        //match(token.KW_ID);
        statement S;
        if(currentToken.getType()== token.KW_ID){

            String id=currentToken.getLexema();
            currentToken=lex.getNextToken(); 
                        S=Fstmnt(id);
            return S;
        }else
        {
            throw new Exception("Se esperaba un id");
        }
       
    }

    private statement Fstmnt(String id) throws Exception
    {
        statement st;
        if(currentToken.getType()==token.SIG_PARIZ)
        {
        st=new MethodCall(lex.getlinea(), id,method_ret());
        
        }else
        {
            Assign as=assign(id);
         st=new AssignStatement(lex.getlinea(),as.getLval(),as.getRval2());
        }
        return st;
    }

}

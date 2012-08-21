package phyton;

import java.io.IOException;
import java.io.InputStream;
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
        program();

    }

    private void program() throws IOException, Exception
    {
      match(token.KW_CLASS);
      match(token.KW_ID);
      match(token.SIG_DP);
      match(token.DELIMITADOR_NL);
      InicioBloque();
      while(currentToken.getType()==token.KW_ID)
      {
        field_decl();
      }
      
      while(currentToken.getType()==token.KW_DEF)
      {
        method_decl();
      }
      FinBloque();
    }

    private void field_decl() throws IOException, Exception
    {
        match(token.KW_ID);
        assign();
        match(token.DELIMITADOR_NL);
    }

    private void method_decl() throws Exception
    {
        match(token.KW_DEF);
        match(token.KW_ID);
        if(currentToken.getType()==token.SIG_PARIZ){
            match(token.SIG_PARIZ);
            match(token.KW_ID);
            while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
                match(token.KW_ID);
            }
         match(token.SIG_PARDE);
        }       
        match(token.SIG_DP);
        block();

    }

    private void assign() throws IOException, Exception
    {
        lvalue();
        match(token.SIG_ASIGNACION);
        expr();
    }

    private void block() throws Exception
    {
        match(token.DELIMITADOR_NL);
        InicioBloque();
        do{
        statement();
        matchE(token.DELIMITADOR_NL);
        }while(isStatement());
        FinBloque();
    }

    private void statement() throws Exception
    {
    if(currentToken.getType()==token.KW_ID)
    {
        statementP();
    }else if(currentToken.getType()==token.KW_PRINT || currentToken.getType()==token.KW_READ)
    {
        method_call();
    }else if(currentToken.getType()==token.KW_IF)
    {
        match(token.KW_IF);
        expr();
        match(token.SIG_DP);
        block();
        while(currentToken.getType()==token.KW_ELIF)
        {
            match(token.KW_ELIF);
            expr();
            match(token.SIG_DP);
            block();
        }
        if(currentToken.getType()==token.KW_ELSE)
        {
            match(token.KW_ELSE);
            match(token.SIG_DP);
            block();
        }
    }else if(currentToken.getType()==token.KW_WHILE)
    {
        match(token.KW_WHILE);
        expr();
        match(token.SIG_DP);
        block();
    }else if(currentToken.getType()==token.KW_FOR)
    {
        match(token.KW_FOR);
        match(token.KW_ID);
        match(token.KW_IN);
        range();
        match(token.SIG_DP);
        block();
    }else if(currentToken.getType()==token.KW_RETURN)
    {
        match(token.KW_RETURN);
        expr();
    }else if(currentToken.getType()==token.KW_BREAK)
    {
        match(token.KW_BREAK);
    }else
    {
        throw new Exception("Se esperaba un statement");
    }
    }

    private void method_call() throws Exception
    {
    if(currentToken.getType()==token.KW_PRINT)
    {
        match(token.KW_PRINT);
        expr();
        while(currentToken.getType()==token.SIG_COMA)
        {
            currentToken=lex.getNextToken();
            expr();
        }
    }else if(currentToken.getType()==token.KW_READ)
    {
        match(token.KW_READ);
        match(token.KW_ID);
        lvalue();
    }else
    {
        throw new Exception("Se esperaba una llamada a un metodo");
    }
    }

    private void lvalue() throws IOException, Exception
    {
        if(currentToken.getType()==token.SIG_CORCHETEIZ)
        {
            match(token.SIG_CORCHETEIZ);
            expr();
            match(token.SIG_CORCHETEDER);
        }

    }

    private void expr() throws IOException, Exception
    {
    if (currentToken.getType()==token.KW_ID)
    {
        ambas();
        exprP();
    }else if(currentToken.getType()== token.LIT_CHCONST || currentToken.getType()== token.LIT_NUM
            ||currentToken.getType()== token.KW_TRUE || currentToken.getType()== token.KW_FALSE)
    {
        constant();
        exprP();
    }else if(currentToken.getType()==token.OP_RESTA)
    {
        match(token.OP_RESTA);
        expr();
        exprP();
    }else if(currentToken.getType()==token.SIG_NEGACION)
    {
        match(token.SIG_NEGACION);
        expr();
        exprP();
    }else if(currentToken.getType()==token.SIG_PARIZ)
    {
        match(token.SIG_PARIZ);
        expr();
        match(token.SIG_PARDE);
        exprP();
    }else if(currentToken.getType()==token.SIG_CORCHETEIZ)
    {
        match(token.SIG_CORCHETEIZ);
         expr();
         while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
                expr();
            }
        match(token.SIG_CORCHETEDER);
        exprP();
    }else
    {
        throw new Exception("se esperaba una expresion");
    }
    }
    private void ambas() throws Exception
    {
        match(token.KW_ID);
        ambasP();
           
    }
    private void method_ret() throws Exception
    {
        match(token.SIG_PARIZ);
        if(isExpr())
        {
       //     currentToken=lex.getNextToken();
            expr();
          while(currentToken.getType()==token.SIG_COMA)
            {
                currentToken=lex.getNextToken();
                expr();
            }
        }
        match(token.SIG_PARDE);

    }

    private void exprP() throws IOException, Exception
    {
        if(currentToken.getType()==token.OP_SUM ||currentToken.getType()==token.OP_RESTA ||
           currentToken.getType()==token.OP_MULTIPLICACION || currentToken.getType()==token.OP_DIVISION ||
           currentToken.getType()==token.OP_MOD || currentToken.getType()==token.OP_SHIFTLEFT ||
           currentToken.getType()==token.OP_SHIFTRIGHT || currentToken.getType()==token.OP_MENOR ||
           currentToken.getType()==token.OP_MENORIGUAL || currentToken.getType()==token.OP_MAYOR ||
           currentToken.getType()==token.OP_MAYORIGUAL || currentToken.getType()==token.OP_COMPARACION ||
           currentToken.getType()==token.OP_DESIGUAL   || currentToken.getType()==token.OP_AND ||
           currentToken.getType()==token.OP_OR || currentToken.getType()==token.OP_NOT)
        {
            op_bin();
            expr();
        }
    }

    private void InicioBloque() throws Exception
    {
        match(token.V_IDNT);
    }

    private void FinBloque() throws Exception
    {
        match(token.V_DDENT);
    }

    private void range() throws Exception
    {
            expr();
            match(token.SIG_RANGO);
            expr();
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

    private void constant() throws Exception
    {
        if(currentToken.getType()==token.LIT_CHCONST || currentToken.getType()==token.LIT_NUM)
        {
            currentToken = lex.getNextToken();
        }else if(currentToken.getType()==token.KW_FALSE || currentToken.getType()==token.KW_TRUE)
        {
            bool_const();
        }else
        {
            throw new Exception("Se esperaba un constant " +lex.getlinea());
        }
    }

    private void bool_const() throws Exception
    {
        if(currentToken.getType()==token.KW_FALSE || currentToken.getType()==token.KW_TRUE)
        {
          currentToken=lex.getNextToken();
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
    private void ambasP() throws Exception
    {
        if(currentToken.getType()==token.SIG_PARIZ)
        {
            method_ret();
        }else
        {
            lvalue();
        }

    }

    private void statementP() throws Exception
    {
        match(token.KW_ID);
        Fstmnt();
    }

    private void Fstmnt() throws Exception
    {
        if(currentToken.getType()==token.SIG_PARIZ)
        {
            method_ret();
        }else
        {
            assign();
        }
    }

}

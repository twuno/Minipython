/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phyton;

/**
 *
 * @author uno
 */
public class token {
    private int type;
    private String lexema;
    public token()
    {
        setType(-1);
        setLexema(null);
    }

    public token(int type, String lexema)
    {
        this.setLexema(lexema);
        this.setType(type);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String NombreToken(int tipo)
    {
        String tipos[]={"OP_SUMA","OP_RESTA","OP_MULTIPLICACION","OP_DIVISION","OP_SHIFTLEFT",
        "OP_SHIFTRIGHT","OP_MOD","OP_MENOR","OP_MAYOR","OP_MENORIGUAL","OP_MAYORIGUAL",
        "OP_COMPARACION","OP_DESIGUAL","OP_AND","OP_OR","OP_NOT","LIT_CHCONST","KW_TRUE",
        "KW_FALSE","KW_CLASS","KW_ID","KW_DEF","KW_IF","KW_ELIF","KW_ELSE","KW_WHILE","KW_FOR"
,"KW_IN","KW_RETURN","KW_BREAK","KW_PRINT","KW_READ","SIG_DP","SIG_COMA","SIG_CORCHETEIZ",
        "SIG_CORCHETEDER","SIG_PARIZ","SIG_PARDE","SIG_NEGACION","DELIMITADOR_TAB","SIG_ASIGNACION",
"SIG_RANGO","DELIMITADOR_NL","V_IDNT","V_DDENT","LIT_NUM","OP_COMENTARIO","EOF","SIG_PUNTO"

        };
        return tipos[tipo];
    }
public static final int OP_SUM = 0;
public static final int OP_RESTA=1;
public static final int OP_MULTIPLICACION=2;
public static final int OP_DIVISION=3;
public static final int OP_SHIFTLEFT=4;
public static final int OP_SHIFTRIGHT=5;
public static final int OP_MOD=6;
public static final int OP_MENOR=7;
public static final int OP_MAYOR=8;
public static final int OP_MENORIGUAL=9;
public static final int OP_MAYORIGUAL=10;
public static final int OP_COMPARACION=11;
public static final int OP_DESIGUAL=12;
public static final int OP_AND=13;public static final int OP_OR=14;public static final int OP_NOT=15;
public static final int LIT_CHCONST=16;public static final int KW_TRUE=17;public static final int KW_FALSE=18;public static final int KW_CLASS=19;
public static final int KW_ID=20;public static final int KW_DEF=21;public static final int KW_IF=22;public static final int KW_ELIF=23;
public static final int KW_ELSE=24;public static final int KW_WHILE=25;public static final int KW_FOR=26;public static final int KW_IN=27;
public static final int KW_RETURN=28;public static final int KW_BREAK=29;public static final int KW_PRINT=30;public static final int KW_READ=31;
public static final int SIG_DP=32;public static final int SIG_COMA=33;public static final int SIG_CORCHETEIZ=34;public static final int SIG_CORCHETEDER=35;
public static final int SIG_PARIZ=36;public static final int SIG_PARDE=37;public static final int SIG_NEGACION=38;public static final int DELIMITADOR_TAB=39;
public static final int SIG_ASIGNACION=40;public static final int SIG_RANGO=41;public static final int DELIMITADOR_NL=42;public static final int V_IDNT=43;
public static final int V_DDENT=44;
public static final int LIT_NUM=45;
public static final int OP_COMENTARIO=46;
public static final int EOF=47;
public static final int SIG_PUNTO=48;

}

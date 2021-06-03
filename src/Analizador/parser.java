
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Thu Jun 03 00:24:41 CST 2021
//----------------------------------------------------

package Analizador;

import java_cup.runtime.*;

/** CUP v0.10k generated parser.
  * @version Thu Jun 03 00:24:41 CST 2021
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\063\000\002\002\004\000\002\027\004\000\002\027" +
    "\003\000\002\030\004\000\002\026\003\000\002\026\003" +
    "\000\002\026\003\000\002\026\003\000\002\026\003\000" +
    "\002\026\003\000\002\026\003\000\002\026\003\000\002" +
    "\026\003\000\002\026\003\000\002\017\004\000\002\017" +
    "\003\000\002\017\003\000\002\007\005\000\002\011\005" +
    "\000\002\022\005\000\002\022\005\000\002\022\005\000" +
    "\002\022\005\000\002\022\005\000\002\023\004\000\002" +
    "\023\003\000\002\014\005\000\002\014\004\000\002\014" +
    "\006\000\002\014\010\000\002\024\003\000\002\024\003" +
    "\000\002\024\003\000\002\024\003\000\002\024\003\000" +
    "\002\024\003\000\002\024\003\000\002\024\003\000\002" +
    "\024\003\000\002\020\005\000\002\005\011\000\002\005" +
    "\015\000\002\004\013\000\002\015\006\000\002\016\003" +
    "\000\002\016\004\000\002\006\011\000\002\010\020\000" +
    "\002\012\014\000\002\021\003\000\002\021\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\002\001\002\000\004\002\005\001\002\000" +
    "\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\004\025\003\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



        public static void main(  args[]) throws Exception{
		new parser(new Yylex(System.in)).parse();
	}
    /**
     * Método al que se llama automáticamente ante algún error sintactico.
     **/ 
    public void syntax_error(Symbol s){ 
        System.out.println("Error Sintáctico en la Línea " + (s.left) +
        " Columna "+s.right+ ". No se esperaba este componente: " +s.value+"."); 
    } 

    /**
     * Método al que se llama automáticamente ante algún error sintáctico 
     * en el que ya no es posible una recuperación de errores.
     **/ 
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
        System.out.println("Error síntactico irrecuperable en la Línea " + 
        (s.left)+ " Columna "+s.right+". Componente " + s.value + 
        " no reconocido."); 
    }  

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // ARGUMENTOS ::= ID ARGUMENTOS 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(15/*ARGUMENTOS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // ARGUMENTOS ::= ID 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(15/*ARGUMENTOS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // PROC01 ::= PROC ID LLAVEA ARGUMENTOS LLAVEC LLAVEA expr_list RETURN VALOR LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*PROC01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-9)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // FOR01 ::= FOR LLAVEA SET01 LLAVEC LLAVEA TEST LLAVEC LLAVEA INCR ID LLAVEC LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*FOR01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-13)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // WHILE01 ::= WHILE LLAVEA TEST LLAVEC LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*WHILE01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // CASE01 ::= CASE CASE01 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(12/*CASE01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // CASE01 ::= CASE 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(12/*CASE01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // CASE ::= AGRUPACION LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(11/*CASE*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // SWITCH01 ::= SWITCH ID LLAVEA CASE01 DEFAULT LLAVEA expr_list LLAVEC LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*SWITCH01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // IF01 ::= IF LLAVEA TEST LLAVEC LLAVEA expr_list LLAVEC ELSE LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*IF01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // IF01 ::= IF LLAVEA TEST LLAVEC LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(3/*IF01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // TEST ::= OPERAR SIMBRELACIONAL OPERAR 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(14/*TEST*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // SIMBRELACIONAL ::= NI 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // SIMBRELACIONAL ::= IN 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // SIMBRELACIONAL ::= NE 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // SIMBRELACIONAL ::= EQ 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // SIMBRELACIONAL ::= MENORIGUAL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // SIMBRELACIONAL ::= MAYORIGUAL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // SIMBRELACIONAL ::= MENOR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // SIMBRELACIONAL ::= MAYOR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // SIMBRELACIONAL ::= IGUAL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(18/*SIMBRELACIONAL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // AGRUPACIONES ::= SET IDE CORCIZQ EXPR OPERACIONES CORCDER 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*AGRUPACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // AGRUPACIONES ::= PUTS LLAVEA expr_list LLAVEC 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(10/*AGRUPACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // AGRUPACIONES ::= PUTS AGRUPACION 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(10/*AGRUPACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // AGRUPACIONES ::= SET ID AGRUPACION 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(10/*AGRUPACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OPERAR ::= NUM 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(17/*OPERAR*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OPERAR ::= IDE ID 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(17/*OPERAR*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OPERACIONES ::= OPERAR PORCENTAJE OPERAR 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*OPERACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OPERACIONES ::= OPERAR DIVISION OPERAR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*OPERACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // OPERACIONES ::= OPERAR MULTIPLICACION OPERAR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*OPERACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // OPERACIONES ::= OPERAR MENOS OPERAR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*OPERACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // OPERACIONES ::= OPERAR MAS OPERAR 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*OPERACIONES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // PUTS01 ::= PUTS IDE ID 
            {
              Object RESULT = null;
		System.out.println ("SENTENCIA CORRECTA");
              CUP$parser$result = new java_cup.runtime.Symbol(7/*PUTS01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // SET01 ::= SET ID VALOR 
            {
              Object RESULT = null;
		System.out.println ("SENTENCIA CORRECTA");
              CUP$parser$result = new java_cup.runtime.Symbol(5/*SET01*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // VALOR ::= ID 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*VALOR*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // VALOR ::= NUM 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*VALOR*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // VALOR ::= IDE ID 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*VALOR*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expr ::= PROC01 
            {
              Object RESULT = null;
		 System.out.println("SENTENCIA CORRECTA"); 
              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expr ::= FOR01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expr ::= WHILE01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expr ::= SWITCH01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expr ::= IF01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expr ::= AGRUPACIONES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expr ::= PUTS01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expr ::= SET01 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // expr ::= IDE 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expr ::= COMENTARIO 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(20/*expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr_part ::= expr PC 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(22/*expr_part*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr_list ::= expr 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(21/*expr_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // expr_list ::= expr expr_list 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(21/*expr_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


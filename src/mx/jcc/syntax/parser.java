
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat May 01 21:21:35 CDT 2021
//----------------------------------------------------

package mx.jcc.syntax;

import mx.jcc.syntax.DeclarationNode;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;
import java_cup.runtime.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat May 01 21:21:35 CDT 2021
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\025\000\002\006\004\000\002\002\004\000\002\007" +
    "\004\000\002\010\004\000\002\010\003\000\002\013\004" +
    "\000\002\002\005\000\002\002\004\000\002\011\004\000" +
    "\002\011\003\000\002\014\004\000\002\003\005\000\002" +
    "\003\004\000\002\015\004\000\002\015\003\000\002\012" +
    "\004\000\002\012\004\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\004\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\041\000\004\005\004\001\002\000\004\005\043\001" +
    "\002\000\002\001\002\000\004\002\027\001\002\000\006" +
    "\004\015\005\004\001\002\000\006\006\012\007\013\001" +
    "\002\000\006\004\ufffd\005\ufffd\001\002\000\004\005\014" +
    "\001\002\000\006\004\ufffc\005\ufffc\001\002\000\006\006" +
    "\ufffb\007\ufffb\001\002\000\004\004\026\001\002\000\004" +
    "\004\ufff8\001\002\000\004\004\015\001\002\000\006\006" +
    "\022\007\023\001\002\000\006\004\ufffe\005\ufffe\001\002" +
    "\000\004\004\024\001\002\000\004\004\ufff7\001\002\000" +
    "\006\006\ufff6\007\ufff6\001\002\000\004\004\ufff9\001\002" +
    "\000\006\006\ufff5\007\ufff5\001\002\000\004\002\000\001" +
    "\002\000\010\004\042\005\040\007\041\001\002\000\004" +
    "\002\001\001\002\000\010\004\036\005\034\007\035\001" +
    "\002\000\004\002\ufff3\001\002\000\010\004\uffed\005\uffed" +
    "\007\uffed\001\002\000\004\002\ufff1\001\002\000\010\004" +
    "\uffee\005\uffee\007\uffee\001\002\000\004\002\ufff4\001\002" +
    "\000\010\004\uffef\005\uffef\007\uffef\001\002\000\004\002" +
    "\ufff2\001\002\000\010\004\ufff0\005\ufff0\007\ufff0\001\002" +
    "\000\006\006\ufffa\007\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\041\000\014\002\007\006\005\007\004\010\006\013" +
    "\010\001\001\000\002\001\001\000\012\004\027\005\031" +
    "\012\032\015\030\001\001\000\002\001\001\000\014\002" +
    "\007\003\017\011\016\013\020\014\015\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\003\017\014\024\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\004\027\005\031\012\036" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
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
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public void insertVariable(String name, VariableType type) {
        if (symbolTable.containsKey(name)) {
            System.err.printf("The variable %s already declared\n", name);
            return;
        }
        symbolTable.put(name, type);
        System.out.printf("Var %s: %s\n", name, type);
    }

    public void insertValue(String name, Variable variable) {
        if (!symbolTable.containsKey(name)) {
            System.err.printf("The nonterminal %s is not declared\n", name);
            return;
        }
        if (!valueTable.containsKey(name)) {
            List<Variable> list = new LinkedList<>();
            valueTable.put(name, list);
        }
        List<Variable> list = valueTable.get(name);
        list.add(variable);
        System.out.printf("Insert %s: %s\n", name, variable.value);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {


    public Map<String, VariableType> symbolTable  = new HashMap<>();
    public Map<String, List<Variable>> valueTable  = new HashMap<>();

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
          case 20: // A ::= CP TERMINAL 
            {
              DeclarationNode RESULT =null;
		int cpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		DeclarationNode cp = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertValue(cp.a, Variable.terminal(vid));
                RESULT = cp;
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // A ::= CP NONTERM 
            {
              DeclarationNode RESULT =null;
		int cpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		DeclarationNode cp = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertValue(cp.a, Variable.nonTerminal(vid));
                RESULT = cp;
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // A ::= A TERMINAL 
            {
              DeclarationNode RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		DeclarationNode a = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertValue(a.a, Variable.terminal(vid));
                RESULT = a;
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // A ::= A NONTERM 
            {
              DeclarationNode RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		DeclarationNode a = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertValue(a.a, Variable.nonTerminal(vid));
                RESULT = a;
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ATT ::= CP EOL 
            {
              Object RESULT =null;
		int cpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		DeclarationNode cp = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
                insertValue(cp.a, Variable.EPSION);
                RESULT = cp;
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ATT",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ATT ::= A EOL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ATT",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // PRODS ::= ATT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PRODS",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // PRODS ::= PRODS ATT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PRODS",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // DNT ::= NONTERM NONTERM 
            {
              DeclarationNode RESULT =null;
		int ntleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int ntright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String nt = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
                insertVariable(vid, VariableType.NON_TERMINAL);
                RESULT = new DeclarationNode(VariableType.NON_TERMINAL, null);
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DNT",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // DNT ::= DNT COMMA NONTERM 
            {
              DeclarationNode RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		DeclarationNode e1 = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertVariable(vid, e1.a);
                RESULT = new DeclarationNode(e1.a, null);
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DNT",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // DNTT ::= DNT EOL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DNTT",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DSNT ::= DNTT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DSNT",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DSNT ::= DSNT DNTT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DSNT",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DT ::= TERMINAL TERMINAL 
            {
              DeclarationNode RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
                insertVariable(vid, VariableType.TERMINAL);
                RESULT = new DeclarationNode(VariableType.TERMINAL, null);
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DT",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // DT ::= DT COMMA TERMINAL 
            {
              DeclarationNode RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		DeclarationNode e1 = (DeclarationNode)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int vidleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vidright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String vid = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
                insertVariable(vid, e1.a);
                RESULT = new DeclarationNode(e1.a, null);
            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DT",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // DTT ::= DT EOL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DTT",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // DST ::= DTT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DST",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // DST ::= DST DTT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DST",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // DECLS ::= DST DSNT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLS",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= initial EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // initial ::= DECLS PRODS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("initial",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

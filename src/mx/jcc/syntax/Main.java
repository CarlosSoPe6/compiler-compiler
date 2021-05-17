package mx.jcc.syntax;

import mx.jcc.analyzer.Action;
import mx.jcc.analyzer.ActionType;
import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.TableBuilder;
import mx.jcc.analyzer.adapters.ProductionRuleListAdapter;
import mx.jcc.analyzer.adapters.SymbolTableListAdapter;
import mx.jcc.analyzer.interfaces.IProductionRuleListAdapter;
import mx.jcc.analyzer.interfaces.ISymbolTableListAdapter;
import mx.jcc.analyzer.sets.FirstSet;
import mx.jcc.analyzer.sets.FollowSet;
import mx.jcc.lexer.Lexer;

import java.io.FileReader;
import java.util.*;

public class Main {
    static public void main(String argv[]) {
        try {
            String url = Main.class.getResource("/input.txt").getFile();
            System.out.println(url);
            FileReader fr = new FileReader(url);

            parser p = new parser(new Lexer(fr));
            Object result = p.parse().value;
            Map<String, VariableType> symbols = p.getActions().symbolTable;
            Map<Variable, List<List<Variable>>> map = p.getActions().valueTable;

            FirstSet firstSetCalulator = new FirstSet();
            FollowSet followSetCalulator = new FollowSet();
            Map<Variable, Set<Variable>> firstSet = firstSetCalulator.computeSet(map, null);
            Map<Variable, Set<Variable>> followSet = followSetCalulator.computeSet(map, firstSet, p.getActions().initial);
            IProductionRuleListAdapter productionRule = new ProductionRuleListAdapter();
            Map<Variable, List<ProductionRule>> rules = productionRule.transform(p.getActions().initial, map);
            ISymbolTableListAdapter symbolAdapter = new SymbolTableListAdapter();
            List<Variable> terminals0 = symbolAdapter.transform(symbols, VariableType.TERMINAL);
            List<Variable> nonTerminals0 = symbolAdapter.transform(symbols, VariableType.NON_TERMINAL);

            List<Variable> terminals = new ArrayList<>();
            terminals.add(new Variable("pa", VariableType.TERMINAL));
            terminals.add(new Variable("pc", VariableType.TERMINAL));
            terminals.add(new Variable("id", VariableType.TERMINAL));
            terminals.add(new Variable("mas", VariableType.TERMINAL));
            terminals.add(new Variable("por", VariableType.TERMINAL));
            terminals.add(new Variable("$", VariableType.EOF));
            List<Variable> nonTerminals = new ArrayList<>();
            nonTerminals.add(new Variable("E", VariableType.NON_TERMINAL));
            nonTerminals.add(new Variable("T", VariableType.NON_TERMINAL));
            nonTerminals.add(new Variable("F", VariableType.NON_TERMINAL));
            Map<Variable, Action> tm = new TreeMap();
            tm.put(new Variable("id", VariableType.TERMINAL), new Action(ActionType.SHIFT, "5"));
            tm.put(new Variable("T", VariableType.NON_TERMINAL), new Action(ActionType.GOTO, "2"));
            tm.put(new Variable("F", VariableType.NON_TERMINAL), new Action(ActionType.GOTO, "3"));
            tm.put(new Variable("pa", VariableType.TERMINAL), new Action(ActionType.REDUCE, "4"));
            tm.put(new Variable("E", VariableType.NON_TERMINAL), new Action(ActionType.GOTO, "1"));
            Map<Variable, Action> tm1 = new TreeMap();
            tm1.put(new Variable("F", VariableType.NON_TERMINAL), new Action(ActionType.GOTO, "8"));
            tm1.put(new Variable("mas", VariableType.TERMINAL), new Action(ActionType.SHIFT, "6"));
            tm1.put(new Variable("$", VariableType.EOF), new Action(ActionType.OK, ""));
            Map<Variable, Action> tm2 = new TreeMap();
            tm2.put(new Variable("F", VariableType.NON_TERMINAL), new Action(ActionType.SHIFT, "6"));
            tm2.put(new Variable("pc", VariableType.TERMINAL), new Action(ActionType.REDUCE, "7"));
            tm2.put(new Variable("mas", VariableType.TERMINAL), new Action(ActionType.REDUCE, "4"));
            tm2.put(new Variable("id", VariableType.TERMINAL), new Action(ActionType.REDUCE, "5"));
            tm2.put(new Variable("por", VariableType.TERMINAL), new Action(ActionType.REDUCE, "5"));
            tm2.put(new Variable("pa", VariableType.TERMINAL), new Action(ActionType.SHIFT, "5"));
            List<Map<Variable, Action>> automa = new ArrayList<>();
            automa.add(tm);
            automa.add(tm1);
            automa.add(tm2);
            new TableBuilder().write(automa, terminals, nonTerminals);

        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

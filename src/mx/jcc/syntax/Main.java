package mx.jcc.syntax;

import mx.jcc.analyzer.*;
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

            AutomatonBuilder automatonBuilder = new AutomatonBuilder();
            //Map<Variable, List<ProductionRule>> grammar = automatonBuilder.getMock();
            List<Map<Variable, Action>> automaton = automatonBuilder.build(rules, followSet);

            new TableBuilder().write(automaton, terminals0, nonTerminals0);

        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

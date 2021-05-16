package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.Action;
import mx.jcc.syntax.Variable;

import java.util.List;
import java.util.Map;

public interface ITableBuilder {
    void write(List<Map<Variable, Action>> automaton, List<Variable> terminals, List<Variable> nonTerminals);
}

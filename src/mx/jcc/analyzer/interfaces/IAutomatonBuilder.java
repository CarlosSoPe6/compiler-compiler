package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.Action;
import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAutomatonBuilder {
    List<Map<Variable, Action>> build(Map<Variable, List<ProductionRule>> grammar, Map<Variable, Set<Variable>> follow);
}

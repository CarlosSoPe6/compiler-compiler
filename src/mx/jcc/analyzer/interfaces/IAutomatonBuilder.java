package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAutomatonBuilder {
    void build(Map<Variable, List<ProductionRule>> grammar, Map<Variable, Set<Variable>> follow);
}

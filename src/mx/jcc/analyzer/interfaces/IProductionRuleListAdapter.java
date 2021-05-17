package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.List;
import java.util.Map;

public interface IProductionRuleListAdapter {
    List<ProductionRule> transform(Variable head, List<List<Variable>> rules);
    Map<Variable, List<ProductionRule>> transform(Variable initial, Map<Variable, List<List<Variable>>> values);
}

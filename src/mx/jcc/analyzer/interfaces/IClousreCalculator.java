package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IClousreCalculator {
    Set<ProductionRule> compute(Set<ProductionRule> kernerId, Map<Variable, List<ProductionRule>> values);
}

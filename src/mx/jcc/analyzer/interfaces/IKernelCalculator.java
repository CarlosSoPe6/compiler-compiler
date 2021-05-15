package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.Map;

public interface IKernelCalculator {
    int compute(ProductionRule rule, Map<Variable, Integer> values);
}

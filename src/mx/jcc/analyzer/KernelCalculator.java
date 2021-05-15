package mx.jcc.analyzer;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IKernelCalculator;
import mx.jcc.syntax.Variable;

import java.util.Map;

public class KernelCalculator implements IKernelCalculator {
    @Override
    public int compute(ProductionRule rule, Map<Variable, Integer> values) {
        return 0;
    }
}

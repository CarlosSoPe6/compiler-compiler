package mx.jcc.analyzer;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IKernelCalculator;
import mx.jcc.syntax.Variable;

import java.util.Map;

public class KernelCalculator implements IKernelCalculator {
    @Override
    public int compute(ProductionRule rule, Map<ProductionRule, Integer> values) {
        if (values.containsKey(rule)) {
            return values.get(rule);
        }
        int max = 0;
        if (!values.values().isEmpty()) {
            max = values.values().stream().max(Integer::compare).get();
        }
        setKernel(rule, values, max + 1);
        return max;
    }

    @Override
    public void setKernel(ProductionRule rule, Map<ProductionRule, Integer> values, int index) {
    }
}

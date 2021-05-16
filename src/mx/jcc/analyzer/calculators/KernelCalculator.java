package mx.jcc.analyzer.calculators;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IKernelCalculator;
import mx.jcc.syntax.Variable;

import java.util.Collections;
import java.util.Map;

public class KernelCalculator implements IKernelCalculator {
    @Override
    public int compute(ProductionRule rule, Map<ProductionRule, Integer> values) {
        if (values.containsKey(rule)) {
            return values.get(rule);
        }
        int max = -1;
        if (!values.values().isEmpty()) {
            max = Collections.max(values.values());
            System.out.println("MAX: " + max);
        }
        max = max + 1;
        setKernel(rule, values, max);
        return max;
    }

    @Override
    public void setKernel(ProductionRule rule, Map<ProductionRule, Integer> values, int index) {
        values.put(rule, index);
    }
}

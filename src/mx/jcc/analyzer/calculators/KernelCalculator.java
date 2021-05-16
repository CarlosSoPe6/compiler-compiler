package mx.jcc.analyzer.calculators;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IKernelCalculator;
import mx.jcc.syntax.Variable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KernelCalculator implements IKernelCalculator {
    public final Map<ProductionRule, Integer> values;

    public KernelCalculator() {
        this.values = new HashMap<>();
    }

    @Override
    public int compute(ProductionRule rule) {
        if (this.values.containsKey(rule)) {
            return this.values.get(rule);
        }
        int max = -1;
        if (!this.values.values().isEmpty()) {
            max = Collections.max(this.values.values());
            System.out.println("MAX: " + max);
        }
        max = max + 1;
        setKernel(rule, max);
        return max;
    }

    @Override
    public void setKernel(ProductionRule rule, int index) {
        this.values.put(rule, index);
    }

    @Override
    public int agregateKernel(ProductionRule insert, ProductionRule search) {
        if (this.values.containsKey(search)) {
            int id = this.values.get(search);
            this.values.put(insert, id);
            return id;
        }
        return compute(insert);
    }
}

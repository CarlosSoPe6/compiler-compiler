package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;

import java.util.Map;

public interface IKernelCalculator {
    int compute(ProductionRule rule, Map<ProductionRule, Integer> values);
    void setKernel(ProductionRule rule, Map<ProductionRule, Integer> values, int index);
}

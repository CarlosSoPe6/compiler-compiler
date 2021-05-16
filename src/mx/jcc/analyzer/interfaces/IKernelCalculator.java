package mx.jcc.analyzer.interfaces;

import mx.jcc.analyzer.ProductionRule;

import java.util.Map;

public interface IKernelCalculator {
    int compute(ProductionRule rule);
    void setKernel(ProductionRule rule, int index);
}

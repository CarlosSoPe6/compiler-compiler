package mx.jcc.analyzer;

import mx.jcc.analyzer.interfaces.IClousreCalculator;
import mx.jcc.syntax.Variable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClousureCalculator implements IClousreCalculator {

    public Set<ProductionRule> compute(Set<ProductionRule> kernerId, Map<Variable, List<ProductionRule>> values) {
        Set<ProductionRule> closure = new HashSet<>();
        closure.addAll(kernerId);
        boolean added = false;
        do {
            added = false;
            for (ProductionRule entry:
                    closure) {
                int trackPointIndex = entry.body.indexOf(Variable.TRACK_POINT);
                if (trackPointIndex == entry.body.size() -1) {
                    continue;
                }
                Variable next = entry.body.get(trackPointIndex + 1);
                if (!next.isTerminal()) {
                    continue;
                }
                // List<ProductionRule> productionRules = this.values.get(next);
                // added = closure.addAll(productionRules);
            }
        } while (!added);
        return closure;
    }
}

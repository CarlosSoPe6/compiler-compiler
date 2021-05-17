package mx.jcc.analyzer.calculators;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IClousreCalculator;
import mx.jcc.syntax.Variable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClousureCalculator implements IClousreCalculator {

    public Set<ProductionRule> compute(Set<ProductionRule> kernerId, Map<Variable, List<ProductionRule>> values) {
        Set<ProductionRule> closure = new HashSet<>(kernerId);
        boolean added;
        do {
            added = false;
            for (int i = 0; i < closure.toArray().length; i++) {
                ProductionRule entry = (ProductionRule) closure.toArray()[i];
                int trackPointIndex = entry.body.indexOf(Variable.TRACK_POINT);
                if (trackPointIndex == entry.body.size() - 1) {
                    continue;
                }
                Variable next = entry.body.get(trackPointIndex + 1);
                if (!next.isNonTerminal()) {
                    continue;
                }

                List<ProductionRule> productionRules = values.get(next);
                added = closure.addAll(productionRules);
                if (added) {
                    i = 0;
                }
            }
        } while (added);
        return closure;
    }
}

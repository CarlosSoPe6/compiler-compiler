package mx.jcc.analyzer.calculators;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IClousreCalculator;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClousureCalculator implements IClousreCalculator {

    public Set<ProductionRule> compute(Set<ProductionRule> kernerId, Map<Variable, List<ProductionRule>> values) {
        Set<ProductionRule> closure = new HashSet<>(kernerId);
        boolean added;
        boolean addedIteration;
        do {
            added = false;
            for (int i = 0; i < closure.toArray().length; i++) {
                ProductionRule entry = (ProductionRule) closure.toArray()[i];

                // reference to Variable.TrackPoint gets lost between swaps
                int trackPointIndex = -1;

                for (int j = 0; j < entry.body.size(); j ++) {
                    if (entry.body.get(j).isTrackPoint()) {
                        trackPointIndex = j;
                        break;
                    }
                }

                //= entry.body.indexOf(Variable.TRACK_POINT);
                if (trackPointIndex == entry.body.size() - 1) {
                    continue;
                }
                Variable next = entry.body.get(trackPointIndex + 1);
                if (!next.isNonTerminal()) {
                    continue;
                }

                List<ProductionRule> productionRules = values.get(next);
                addedIteration = closure.addAll(productionRules);
                if (addedIteration) {
                    i = 0;
                    added = true;
                }
            }
        } while (added);
        return closure;
    }
}

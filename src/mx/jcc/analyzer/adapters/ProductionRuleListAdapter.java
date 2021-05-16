package mx.jcc.analyzer.adapters;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.analyzer.interfaces.IProductionRuleListAdapter;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.util.*;

public class ProductionRuleListAdapter implements IProductionRuleListAdapter {

    @Override
    public List<ProductionRule> transform(Variable head, List<List<Variable>> rules) {
        List<ProductionRule> transform = new LinkedList<>();
        for (List<Variable> rule :
                rules) {
            if (rule.isEmpty()) {
                continue;
            }
            List<Variable> tempBody = new LinkedList<>();
            tempBody.add(Variable.TRACK_POINT);
            tempBody.addAll(rule);
            ProductionRule tempRule = new ProductionRule(head, tempBody);
            transform.add(tempRule);
        }

        return transform;
    }

    @Override
    public Map<Variable, List<ProductionRule>> transform(Variable initial, Map<Variable, List<List<Variable>>> values) {
        Map<Variable, List<ProductionRule>> map = new HashMap<>();
        for (Variable head:
             values.keySet()) {
            map.put(head, this.transform(head, values.get(head)));
        }
        Variable[] initialBodyArray = { Variable.TRACK_POINT, initial };
        ProductionRule initialBodyElement = new ProductionRule(Variable.INITIAL, Arrays.asList(initialBodyArray));
        List<ProductionRule> initialBody = new ArrayList<>(1);
        initialBody.add(initialBodyElement);
        map.put(Variable.INITIAL, initialBody);
        return map;
    }
}

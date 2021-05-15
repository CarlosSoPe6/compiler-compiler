package mx.jcc.analyzer;

import mx.jcc.analyzer.ProductionRule;
import mx.jcc.syntax.Variable;

import java.util.LinkedList;
import java.util.List;

public class ProductionRuleListAdapter {
    public ProductionRuleListAdapter() {}

    public List<ProductionRule> trasnformTo(Variable head, List<List<Variable>> rules) {
        List<ProductionRule> transform = new LinkedList<>();
        for (List<Variable> rule :
                rules) {
            List<Variable> tempBody = new LinkedList<>();
            tempBody.add(Variable.TRACK_POINT);
            tempBody.addAll(rule);
            ProductionRule tempRule = new ProductionRule(head, tempBody);
            transform.add(tempRule);
        }

        return transform;
    }
}

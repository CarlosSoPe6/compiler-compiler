package mx.jcc.analyzer.sets;

import mx.jcc.syntax.Variable;

import java.util.*;

public class FirstSet {
    public Map<Variable, Set<Variable>> computeSet(Map<Variable, List<List<Variable>>> valueTable, Variable initial) {
        Set<Variable> keySet = valueTable.keySet();
        Map<Variable, Set<Variable>> fistSet = new HashMap<>();
        Set<Variable> visited = new HashSet<>();
        for (Variable head :
                keySet) {
            fistSet.put(head, new HashSet<>());
        }
        for (Variable head :
                keySet) {
            dfsFistSet(
                    valueTable,
                    fistSet,
                    visited,
                    head
            );
        }
        return fistSet;
    }

    private Set<Variable> dfsFistSet(
            Map<Variable, List<List<Variable>>> valueTable,
            Map<Variable, Set<Variable>> firstSet,
            Set<Variable> visited,
            Variable head
    ) {
        if (visited.contains(head)) {
            return firstSet.get(head);
        }
        Set<Variable> returnSet = new HashSet<>();
        visited.add(head);
        List<List<Variable>> rules = valueTable.get(head);
        for (List<Variable> rule :
                rules) {
            for (int i = 0; i < rule.size(); i++) {
                Variable variable = rule.get(i);
                switch (variable.type) {
                    case EPSILON:
                        returnSet.add(Variable.EPSILON);
                        i = rule.size();
                        break;
                    case NON_TERMINAL:
                        returnSet.remove(Variable.EPSILON);
                        Set<Variable> depthSet = dfsFistSet(
                                valueTable,
                                firstSet,
                                visited,
                                variable
                        );
                        if (!depthSet.contains(Variable.EPSILON)) {
                            i = rule.size();
                        }
                        returnSet.addAll(depthSet);
                        break;
                    case TERMINAL:
                        returnSet.remove(Variable.EPSILON);
                        returnSet.add(variable);
                        i = rule.size();
                        break;
                }
            }
        }
        firstSet.get(head).addAll(returnSet);
        return returnSet;
    }
}

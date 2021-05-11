package mx.jcc.analyzer.sets;

import mx.jcc.syntax.Variable;

import java.util.*;

public class FollowSet {
    public Map<Variable, Set<Variable>> computeSet(Map<Variable, List<List<Variable>>> valueTable, Map<Variable, Set<Variable>> firstSet, Variable initial) {
        Set<Variable> keySet = valueTable.keySet();
        Map<Variable, Set<Variable>> followSet = new HashMap<>();
        for (Variable head :
                keySet) {
            followSet.put(head, new HashSet<>());
        }
        followSet.get(initial).add(Variable.EOF);
        for (Variable head :
                keySet) {
            Set<Variable> visited = new HashSet<>();
            Set<Variable> returnSet = searchFollow(
                    valueTable,
                    firstSet,
                    followSet,
                    visited,
                    head,
                    initial
            );
            followSet.get(head).addAll(returnSet);
        }
        return followSet;
    }

    private Set<Variable> searchFollow(
            Map<Variable, List<List<Variable>>> valueTable,
            Map<Variable, Set<Variable>> firstSet,
            Map<Variable, Set<Variable>> followSet,
            Set<Variable> visited,
            Variable search,
            Variable initial
    ) {
        if (visited.contains(search)) {
            return followSet.get(search);
        }
        visited.add(search);
        Set<Variable> returnSet = new HashSet<>();
        if (search.equals(initial)) {
            returnSet.add(Variable.EOF);
        }
        System.out.println();
        for (Map.Entry<Variable, List<List<Variable>>> rules : valueTable.entrySet()) {
            System.out.printf("Search: %s, At: %s\n",search, rules.getKey());
            for (List<Variable> rule : rules.getValue()
                 ) {
                for (int i = 0; i < rule.size(); i++) {
                    Variable variable = rule.get(i);
                    if (variable.equals(search)) {
                        if (i + 1 == rule.size()) {
                            // If last element
                            // CASO 3
                            returnSet.addAll(
                                    searchFollow(
                                            valueTable,
                                            firstSet,
                                            followSet,
                                            visited,
                                            rules.getKey(),
                                            initial
                                    )
                            );
                        } else {
                            Variable follow = rule.get(i + 1);
                            Set<Variable> firstfollow = firstSet.get(follow);
                            switch (follow.type) {
                                case TERMINAL:
                                    // CASO 2
                                    returnSet.add(follow);
                                    break;
                                case NON_TERMINAL:
                                    if (firstfollow.contains(Variable.EPSION)) {
                                        // CASO 3
                                        returnSet.addAll(
                                                searchFollow(
                                                        valueTable,
                                                        firstSet,
                                                        followSet,
                                                        visited,
                                                        rules.getKey(),
                                                        initial
                                                )
                                        );
                                    }
                                    // CASO 2
                                    returnSet.addAll(firstfollow);
                            }
                        }
                    }
                }
            }
        }

        return returnSet;
    }
}

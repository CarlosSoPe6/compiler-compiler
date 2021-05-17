package mx.jcc.analyzer;

import mx.jcc.analyzer.calculators.ClousureCalculator;
import mx.jcc.analyzer.calculators.KernelCalculator;
import mx.jcc.analyzer.interfaces.IAutomatonBuilder;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.util.*;

public class AutomatonBuilder implements IAutomatonBuilder {

    Map<Variable, List<ProductionRule>> values;

    @Override
    public List<Map<Variable, Action>> build(Map<Variable, List<ProductionRule>> grammar, Map<Variable, Set<Variable>> follow) {
        // Declaration phase
        List<Map<Variable, Action>> automaton = new ArrayList<>();
        KernelCalculator kernelCalculator = new KernelCalculator();
        ClousureCalculator clousureCalculator = new ClousureCalculator();
        ProductionRule firstRule = grammar.get(Variable.INITIAL).get(0);
        Queue<Integer> states = new LinkedList<>();



        // First case: Given the initial rule, generate the initial kernel, closure and state
        states.offer(0);
        kernelCalculator.setKernel(firstRule, 0);
        Set<ProductionRule> kernel = new HashSet<>();
        kernel.add(firstRule);
        System.out.println("calculator> " + kernelCalculator.compute(firstRule));
        Set<ProductionRule> closure = clousureCalculator.compute(kernel, grammar);

        Map<String, Integer> knownVariables = new HashMap<>();
        Map<Variable, Action> initialState = new TreeMap<>();
        int stateIndex = 1;
        for (ProductionRule rule : closure) {
            Variable first = rule.body.get(1);

            if (first.isNonTerminal()) {

                if (!knownVariables.containsKey(first.value)) {
                    initialState.put(first, new Action(ActionType.GOTO, String.valueOf(stateIndex)));
                    knownVariables.put(first.value, stateIndex);
                    kernelCalculator.setKernel(nextVar(rule), stateIndex);
                    stateIndex ++;
                } else {
                    System.out.println("Goto; " + knownVariables.get(first.value));
                    kernelCalculator.setKernel(nextVar(rule), knownVariables.get(first.value));
                }

            } else if (first.isTerminal()) {

                if (!initialState.containsKey(first)) {
                    initialState.put(first, new Action(ActionType.SHIFT, String.valueOf(stateIndex)));
                    kernelCalculator.setKernel(nextVar(rule), stateIndex);
                    stateIndex ++;
                } else {
                    System.out.println(Integer.parseInt("shift; " + initialState.get(first).value));
                    kernelCalculator.setKernel(nextVar(rule), Integer.parseInt(initialState.get(first).value));
                }

            }
        }
        automaton.add(initialState);

        System.out.println("Kernel Values: " + kernelCalculator.values);
        System.out.println("This is the first state " + initialState);
        System.out.println("This is closure> " + closure);

        return null;
    }

    public ProductionRule nextVar(ProductionRule rule) {
        int indexOfTrackPoint = rule.body.indexOf(Variable.TRACK_POINT);

        if (indexOfTrackPoint == rule.body.size() - 1) {
            return null;
        }
        Collections.swap(rule.body, indexOfTrackPoint, indexOfTrackPoint + 1);

        return rule;
    }

    public  Map<Variable, List<ProductionRule>> getMock() {
        Map<Variable, List<ProductionRule>> mockGrammar = new HashMap<>();

        // Non terminal Variables
        Variable e = new Variable("E", VariableType.NON_TERMINAL);
        Variable f = new Variable("F", VariableType.NON_TERMINAL);
        Variable t = new Variable("T", VariableType.NON_TERMINAL);
        Variable first = Variable.INITIAL;

        // Terminal variables
        Variable track = Variable.TRACK_POINT;
        Variable mas = new Variable("mas", VariableType.TERMINAL);
        Variable pa = new Variable("pa", VariableType.TERMINAL);
        Variable pc = new Variable("pc", VariableType.TERMINAL);
        Variable id = new Variable("id", VariableType.TERMINAL);
        Variable por = new Variable("por", VariableType.TERMINAL);

        // Production Rules
        List<Variable> mockList0 = new LinkedList<>();
        mockList0.add(track);
        mockList0.add(e);
        ProductionRule _0 = new ProductionRule(first, mockList0);

        List<Variable> mockList1 = new LinkedList<>();
        mockList1.add(track);
        mockList1.add(e);
        mockList1.add(mas);
        mockList1.add(t);
        ProductionRule _1 = new ProductionRule(e, mockList1);

        List<Variable> mockList2 = new LinkedList<>();
        mockList2.add(track);
        mockList2.add(t);
        ProductionRule _2 = new ProductionRule(e, mockList2);

        List<Variable> mockList3 = new LinkedList<>();
        mockList3.add(track);
        mockList3.add(t);
        mockList3.add(por);
        mockList3.add(f);
        ProductionRule _3 = new ProductionRule(t, mockList3);

        List<Variable> mockList4 = new LinkedList<>();
        mockList4.add(track);
        mockList4.add(f);
        ProductionRule _4 = new ProductionRule(t, mockList4);

        List<Variable> mockList5 = new LinkedList<>();
        mockList5.add(track);
        mockList5.add(pa);
        mockList5.add(e);
        mockList5.add(pc);
        ProductionRule _5 = new ProductionRule(f, mockList5);

        List<Variable> mockList6 = new LinkedList<>();
        mockList6.add(track);
        mockList6.add(id);
        ProductionRule _6 = new ProductionRule(f, mockList6);

        List<ProductionRule> mockProductionListFirst = new LinkedList<>();
        List<ProductionRule> mockProductionListE = new LinkedList<>();
        List<ProductionRule> mockProductionListT = new LinkedList<>();
        List<ProductionRule> mockProductionListF = new LinkedList<>();

        mockProductionListFirst.add(_0);
        mockProductionListE.add(_1);
        mockProductionListE.add(_2);
        mockProductionListT.add(_3);
        mockProductionListT.add(_4);
        mockProductionListF.add(_5);
        mockProductionListF.add(_6);

        mockGrammar.put(first, mockProductionListFirst);
        mockGrammar.put(e, mockProductionListE);
        mockGrammar.put(t, mockProductionListT);
        mockGrammar.put(f, mockProductionListF);


        return mockGrammar;
    }
}

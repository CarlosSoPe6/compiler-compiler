package mx.jcc.analyzer;

import mx.jcc.analyzer.interfaces.IAutomatonBuilder;
import mx.jcc.syntax.Variable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutomatonBuilder implements IAutomatonBuilder {

    Map<Variable, List<ProductionRule>> values;

    @Override
    public void build(Map<Variable, List<ProductionRule>> grammar, Map<Variable, Set<Variable>> follow) {

    }
}

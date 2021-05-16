package mx.jcc.analyzer.adapters;

import mx.jcc.analyzer.interfaces.ISymbolTableListAdapter;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTableListAdapter implements ISymbolTableListAdapter {
    @Override
    public List<Variable> transform(Map<String, VariableType> symbolTable, VariableType type) {
        List<Variable> list = new ArrayList<>();
        for (Map.Entry<String, VariableType> entry:
             symbolTable.entrySet()) {
            if (entry.getValue() == type) {
                list.add(new Variable(entry.getKey(), entry.getValue()));
            }
        }
        return list;
    }
}

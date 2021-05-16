package mx.jcc.analyzer.interfaces;

import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.util.List;
import java.util.Map;

public interface ISymbolTableListAdapter {
    List<Variable> transform(Map<String, VariableType> symbolTable, VariableType type);
}

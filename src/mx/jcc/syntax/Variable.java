package mx.jcc.syntax;

import java.util.Objects;

public class Variable {
    public String value;
    public VariableType type;

    public static final Variable EPSION = new Variable(null, VariableType.EPSILON);
    public static final Variable EOF = new Variable(null, VariableType.EOF);

    public Variable(String value, VariableType type){
        this.type = type;
        this.value = value;
    }

    public boolean isEpsilon() {
        return this.type == VariableType.EPSILON;
    }

    public boolean isTerminal() {
        return this.type == VariableType.TERMINAL;
    }

    public boolean isNonTerminal() {
        return this.type == VariableType.NON_TERMINAL;
    }

    public boolean isEOF() {
        return this.type == VariableType.EOF;
    }

    @Override
    public String toString() {
        return "Variable{" + value + "\\" + type + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        if (value == null && variable.value == null) return true;
        return Objects.equals(value, variable.value) && type == variable.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}

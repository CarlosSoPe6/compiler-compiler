package mx.jcc.syntax;

import java.util.Objects;

public class Variable implements Comparable {
    public String value;
    public VariableType type;

    public static final Variable EPSILON = new Variable(null, VariableType.EPSILON);
    public static final Variable EOF = new Variable(null, VariableType.EOF);
    public static final Variable TRACK_POINT = new Variable(null, VariableType.TRACK_POINT);

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

    public boolean isTrackPoint() {return  this.type == VariableType.TRACK_POINT; }

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

    @Override
    public int compareTo(Object o) {
        return this.value.compareTo(((Variable) o).value);
    }
}

package mx.jcc.syntax;

public class Variable {
    public String value;
    public VariableType type;

    public static final Variable EPSION = new Variable(null, VariableType.EPSILON);

    public Variable(String value, VariableType type){
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Variable{" + value + "\\" + type + "}";
    }
}

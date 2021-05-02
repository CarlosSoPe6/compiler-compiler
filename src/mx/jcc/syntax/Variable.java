package mx.jcc.syntax;

public class Variable {
    public String value;
    public VariableType type;

    public static final Variable EPSION = new Variable(null, VariableType.EPSILON);

    private Variable(String value, VariableType type){
        this.type = type;
        this.value = value;
    }

    public static Variable nonTerminal(String value) {
        return new Variable(value, VariableType.NON_TERMINAL);
    }

    public static Variable terminal(String value) {
        return new Variable(value, VariableType.TERMINAL);
    }
}

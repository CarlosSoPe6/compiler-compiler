package mx.jcc.analyzer;

public class Action {
    public ActionType type;
    public String value;

    public Action(ActionType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Action {" +
                "type=" + type +
                "  state='" + value + '\'' +
                "} ";
    }
}

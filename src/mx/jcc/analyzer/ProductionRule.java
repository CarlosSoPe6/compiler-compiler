package mx.jcc.analyzer;

import mx.jcc.syntax.Variable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductionRule {
    public Variable head;
    public List<Variable> body;

    public ProductionRule(Variable head, List<Variable> body) {
        this.body = body;
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionRule that = (ProductionRule) o;
        return head.equals(that.head) && body.equals(that.body);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.head.value);
        builder.append("->");
        for (Variable prod :
                this.body) {
            builder.append(prod.value);
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, body);
    }

    @Override
    protected Object clone() {
        ProductionRule returnObject = null;
        try {
            returnObject = (ProductionRule) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (returnObject == null) {
                returnObject = new ProductionRule(null, null);
            }
        }
        returnObject.head = this.head;
        returnObject.body = new LinkedList<>();
        returnObject.body.addAll(this.body);
        return returnObject;
    }
}

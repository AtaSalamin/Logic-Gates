/**
 *
 * @author ata_s
 */
import java.util.Map;

public class BoolExpr {
    private String expr;

    public BoolExpr(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }

    public boolean evaluate(Map<Character, Boolean> values) {
        expr = expr.replace(" ", "");
        return parse(expr, values);
    }

    private boolean parse(String expr, Map<Character, Boolean> values) {
        if (expr.startsWith("~")) {
            return !parse(expr.substring(1), values);
        }
        if (expr.contains(".")) {
            String[] parts = expr.split("\\.");
            return parse(parts[0], values) && parse(parts[1], values);
        }
        if (expr.contains("+")) {
            String[] parts = expr.split("\\+");
            return parse(parts[0], values) || parse(parts[1], values);
        }
        return values.getOrDefault(expr.charAt(0), false);
    }
}

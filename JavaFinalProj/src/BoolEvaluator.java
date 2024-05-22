import java.util.*;

public class BoolEvaluator {
    private Map<Character, Integer> variables;

    public BoolEvaluator(Map<Character, Integer> variables) {
        this.variables = variables;
    }

    public int evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                values.push(ch - '0');
            } else if (Character.isLetter(ch)) {
                values.push(variables.get(ch));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (ch == '+' || ch == '.' || ch == '~') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.isEmpty() ? 0 : values.pop()));
        }

        return values.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '.' || op1 == '+') && op2 == '~') {
            return false;
        } else {
            return true;
        }
    }

    private int applyOperator(char op, int b, int a) {
        switch (op) {
            case '+':
                return a | b;
            case '.':
                return a & b;
            case '~':
                return b == 0 ? 1 : 0;
        }
        return 0;
    }
}

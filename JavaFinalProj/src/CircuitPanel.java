import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class CircuitPanel extends JPanel {
    private List<String> expressions;
    private Map<Character, Integer> variables;

    public CircuitPanel(List<String> expressions, Map<Character, Integer> variables) {
        this.expressions = expressions;
        this.variables = variables;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50, y = 50;

        for (String expr : expressions) {
            drawExpression(g, expr, x, y);
            y += 100;
        }
    }

   private void drawExpression(Graphics g, String expr, int x, int y) {
    int variableX = x; 
    int gateX = x + 150; 
    int variableY = y; 
    int gateY = y; 

   
    for (int i = 0; i < expr.length(); i++) {
        char ch = expr.charAt(i);

        if (ch == '+') {
            g.drawLine(variableX + 40, variableY + 5, gateX, gateY + 5); 
            OrGate orGate = new OrGate(gateX, gateY - 20);
            orGate.draw(g);
            g.drawString("OR", gateX + 10, gateY - 25); 
            gateX += 150; 
        } else if (ch == '.') {
            g.drawLine(variableX + 40, variableY + 5, gateX, gateY + 5); 
            AndGate andGate = new AndGate(gateX, gateY - 20);
            andGate.draw(g);
            g.drawString("AND", gateX + 10, gateY - 25); 
            gateX += 150; 
        } else if (ch == '~') {
            g.drawLine(variableX + 40, variableY + 5, gateX, gateY + 5); 
            NotGate notGate = new NotGate(gateX, gateY - 20);
            notGate.draw(g);
            g.drawString("NOT", gateX + 10, gateY - 25); 
            gateX += 150; 
        } else {
            g.drawString(String.valueOf(ch), variableX, variableY);
            g.drawLine(variableX + 20, variableY + 5, variableX + 40, variableY + 5); 

            
            Integer value = variables.get(ch);
            if (value != null) {
                g.drawString(String.valueOf(value), variableX + 45, variableY); 
            }
            variableY += 30; 
        }
    }

    
    BoolEvaluator evaluator = new BoolEvaluator(variables);
    try {
        int result = evaluator.evaluate(expr);
        g.drawString(" = " + result, gateX + 10, gateY); 
    } catch (IllegalArgumentException e) {
        g.drawString(" Error: " + e.getMessage(), gateX + 10, gateY);
    }
}


    public static void main(String[] args) {
        JFrame frame = new JFrame("Circuit Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        List<String> expressions = List.of("A+B", "A.B", "~A");
        Map<Character, Integer> variables = Map.of('A', 1, 'B', 0);

        CircuitPanel panel = new CircuitPanel(expressions, variables);
        frame.add(panel);
        frame.setVisible(true);
    }
}

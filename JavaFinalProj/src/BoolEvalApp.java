import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BoolEvalApp {
    public static void main(String[] args) {
        try {
            InputParser parser = new InputParser("data.txt");
            List<String> expressions = parser.getExpressions();
            Map<Character, Integer> variables = parser.getVariables();

            BoolEvaluator evaluator = new BoolEvaluator(variables);

           
            for (String expr : expressions) {
                int result = evaluator.evaluate(expr);
                System.out.println(expr + " = " + result);
            }

            
            JFrame frame = new JFrame("Circuit Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            CircuitPanel panel = new CircuitPanel(expressions, variables);
            frame.add(panel);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

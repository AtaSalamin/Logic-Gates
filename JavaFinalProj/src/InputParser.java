import java.io.*;
import java.util.*;

public class InputParser {
    private List<String> expressions;
    private Map<Character, Integer> variables;

    public InputParser(String filename) throws IOException {
        expressions = new ArrayList<>();
        variables = new HashMap<>();
        parseFile(filename);
    }

    private void parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("=")) {
                String[] parts = line.split("=");
                variables.put(parts[0].charAt(0), Integer.parseInt(parts[1]));
            } else {
                expressions.add(line);
            }
        }
        reader.close();
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public Map<Character, Integer> getVariables() {
        return variables;
    }
}

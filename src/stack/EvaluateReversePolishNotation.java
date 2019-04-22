package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    /**
     * more slower with Function
     */
    class Solution {
        public int evalRPN(String[] tokens) {

            Map<String, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
            op.put("+", (x, y) -> x + y);
            op.put("-", (x, y) -> x - y);
            op.put("*", (x, y) -> x * y);
            op.put("/", (x, y) -> x / y);
            Stack<String> s = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (op.containsKey(tokens[i])) {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(String.valueOf(op.get(tokens[i]).apply(num1, num2)));
                } else {
                    s.push(tokens[i]);
                }
            }
            return Integer.parseInt(s.pop());
        }
    }

    class Solution1 {
        public int evalRPN(String[] tokens) {

            Stack<String> s = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("+")) {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(String.valueOf(num1 + num2));
                } else if (tokens[i].equals("-")) {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(String.valueOf(num1 - num2));
                } else if (tokens[i].equals("*")) {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(String.valueOf(num1 * num2));
                } else if (tokens[i].equals("/")) {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(String.valueOf(num1 / num2));
                } else {
                    s.push(tokens[i]);
                }
            }
            return Integer.parseInt(s.pop());
        }
    }
}

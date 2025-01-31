package stack;

import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {

            if (isOperand(t)) {
                // Step 2: pop off the stacks and do the op
                int p1 = stack.pop(), p2 = stack.pop();
                int res = -1;
                switch (t) {
                    case "/":
                        res = p2 / p1;
                        break;
                    case "*":
                        res = p1 * p2;
                        break;
                    case "+":
                        res = p1 + p2;
                        break;
                    case "-":
                        res = p2 - p1;
                        break;
                }
                // step 3: push back onto stack
                stack.push(res);
            } else { // just push the parsed number.
                stack.push(Integer.valueOf(t));
            }

        }

        if (stack.size() != 1) return -1;
        return stack.pop();
    }

    public static boolean isOperand(String t) {
        return t.equals("+") || t.equals("-") || t.equals("/")  || t.equals("*");
    }

    public static void main(String[] args) {
        String[] tokens = {"1","2","/", "3", "+"};

        int res = evalRPN(tokens);

        System.out.printf("Evaluation of %s gives us: %d", List.of(tokens), res);
    }
}

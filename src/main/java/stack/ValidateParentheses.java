package stack;

import java.util.Set;
import java.util.Stack;

public class ValidateParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Set<Character> openers = Set.of('(', '[', '{');

        for (char c : s.toCharArray()) {
            if (openers.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char lastPushed = stack.pop();
                if (!matches(c, lastPushed)) return false;
            }
        }

        return stack.isEmpty();
    }

    // could use a map too...
    public static boolean matches(char c, char lastPopped) {
        return (c == ')' && lastPopped == '(')
                || (c == ']' && lastPopped == '[')
                || (c == '}' && lastPopped == '{');

    }

    public static void main(String[] args) {
        String input = "[";

        System.out.println(String.format("Input String: %s isValid?: ", input, isValid(input)));
    }
}

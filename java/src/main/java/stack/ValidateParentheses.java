package stack;

import java.util.Map;
import java.util.Stack;

public class ValidateParentheses {

    static final Map<Character, Character> MAP = Map.of(
            ')','(',
            '}','{',
            ']','[');

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!MAP.containsKey(c)) {
                stack.push(c);
            }
            // Character is a closer.
            else {
                char expected = MAP.get(c);
                if (stack.isEmpty() || expected != stack.pop()) return false;
            }
        }


        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String input = "[";

        System.out.println(String.format("Input String: %s isValid?: %s", input, isValid(input)));
    }
}

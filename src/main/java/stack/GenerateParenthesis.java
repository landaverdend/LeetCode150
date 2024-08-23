package stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        List<String> theList = new ArrayList<>();

        dfs(theList, "", n, 0, 0);


        return theList;
    }


    // Idea: if we only add closing parenthesis when the amount of closers is less than openers, then we can use backtracking and fill in the solutions recursively.
    public static void dfs(List<String> list, String stack, int n, int open, int closed) {
        if (open > n || closed > open) return; // open == closed == n.

        // Valid case where criterion has been reached...
        if (open == closed && open == n) {
            list.add(stack);
            return;
        }

        dfs(list, stack + "(", n, open + 1, closed);
        dfs(list, stack + ")", n, open, closed + 1);


    }


    public static void main(String[] args) {

    }
}

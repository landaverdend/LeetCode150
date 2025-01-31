package stack;

import java.util.List;
import java.util.Stack;

class Tuple {

    public Tuple(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
    int temp;
    int index;
}

public class DailyTemperatures {

    // O(N) solution.
    public static int[] dailyTemperatures(int[] temps) {
        int[] toRet = new int[temps.length];
        Stack<Tuple> stack = new Stack<>();

        // Idea: We want the stack to be in 'monotonic decreasing order'. So iterate through
        // the array and add to the stack in decreasing order. If we encounter something greater than our min, then pop off the stack
        // until we reach a new min or the end of the stack.
        for (int i = 0; i < temps.length; i++) {

            // Stack.peek() should always be the min value we have seen thus far.
            while (!stack.isEmpty() && temps[i] > stack.peek().temp) {

                Tuple pop = stack.pop();
                // compare the index of what was on the stack to what we are currently at.
                // Set the days since by subtracting current day to the day the temp was pushed on (pop.index)

                toRet[pop.index] = i - pop.index;
            }
            stack.push(new Tuple(temps[i], i));

        }

        return toRet;
    }

    public static void main(String[] args) {

        int[] in = {22,21,24};

        int[] out = dailyTemperatures(in);

        System.out.printf("Input: %s\n Output: %s", List.of(in).toString(), List.of(out).toString());

    }
}

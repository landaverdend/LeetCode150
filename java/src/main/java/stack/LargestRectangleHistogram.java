package stack;

import java.util.List;
import java.util.Stack;

class Rectangle {

    int height;
    int ind;

    public Rectangle (int ind, int height) {
        this.height = height;
        this.ind = ind;
    }
}

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Rectangle> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        // As we go through the heights array, there are a few cases we want to keep in mind.
        // 1. If the height at the current index is GREATER than what is on the stack, just push the rectangle as starting with the current height and index.
        // 2. If the height at the current index is LESS than what is on the stack, we want to pop off everything on the stack that is less than the current height.
        //    We will then want to push a new rectangle onto the stack that has a starting index of each rectangle that it replaces....
        // 3. Once we run through the entire input array, what is left are the rectangles that run through till the end. Pop everything off of the stack and calculate their area.
        for (int i = 0; i < heights.length; i++) {

            Rectangle cur = new Rectangle(i, heights[i]);

            while (!stack.isEmpty() && stack.peek().height > cur.height) {
                Rectangle pop = stack.pop(); // Pop off the stack and calculate the area....
                // the width is (i - pop.ind)
                int area = (i - pop.ind) * pop.height;

                max = Math.max(area, max);
                // update the cur starting index...
                cur.ind = pop.ind;
            }
            stack.push(cur);
        }

        // Go through whatever remains on the stack, and calculate the respective areas
        while (!stack.isEmpty()) {
            Rectangle r = stack.pop();

            int area = (heights.length - r.ind) * r.height;
            max = Math.max(area, max);

        }

        return max;
    }

    public static void main(String[] args ) {
        int[] in = {2,1,5,6,2,3};

        System.out.printf("Max value for input array %s is %d", List.of(in), largestRectangleArea(in));
    }
}

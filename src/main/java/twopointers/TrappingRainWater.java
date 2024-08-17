package twopointers;

public class TrappingRainWater {

    public static int trap(int[] height) {

        // This is an O(N) time and memory solution solution.
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // go through and calculate the max value to the left...
        int maxL = Integer.MIN_VALUE;
        maxLeft[0] = 0; // will always be 0.
        for (int i = 1; i < height.length; i++) {
            maxL = Math.max(maxL, height[i - 1]);
            maxLeft[i] = maxL;
        }

        // Go through in reverse and calculate what we can hold..
        int maxR = Integer.MIN_VALUE;
        maxRight[height.length - 1] = 0; // will always be 0...
        for (int i = height.length - 2; i >= 0; i--) {
            maxR = Math.max(maxR, height[i + 1]);
            maxRight[i] = maxR;
        }

        // then go through both one more time and tally the sum of min(maxL[i], maxR[i])
        int[] minLR = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int ugh = minLR[i] - height[i];

            sum += Math.max(0, ugh); // if ugh is below 0 then just set it to 0.
        }

        return sum;
    }


    // Using left and right pointers....
    public static int trap2(int[] height) {
        int sum = 0;
        int l = 0, r = height.length - 1;

        int maxL = height[l], maxR = height[r];


        while (l < r) {
            // l is the smaller side...
            if (maxL <= maxR) {
                l++;
                maxL = Math.max(height[l], maxL);
                int storeable = maxL - height[l];
                sum += Math.max(0, storeable);
            }
            // Max r is the min of min(maxR, maxL)
            else {
                r--;
                maxR = Math.max(height[r], maxR);
                int storeable = maxR - height[r];
                sum += Math.max(0, storeable);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        trap(arr);
        trap2(arr);
    }
}

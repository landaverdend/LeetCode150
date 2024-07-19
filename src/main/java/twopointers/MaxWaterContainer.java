package twopointers;

import java.util.List;

public class MaxWaterContainer {

    public static int maxArea(int[] nums) {

        int l = 0, r = nums.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (l < r) {

            int width = r - l;
            int height = Math.min(nums[l], nums[r]);
            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if (nums[l] < nums[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }



    public static void main(String[] args) {

        int[] in = {1,7,2,5,4,7,3,6};

        int maxArea = maxArea(in);

        System.out.printf("Max area in the array %s is %d", List.of(in), maxArea);
    }
}

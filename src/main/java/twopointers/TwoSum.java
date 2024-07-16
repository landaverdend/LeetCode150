package twopointers;

import java.util.List;

public class TwoSum {

    // [1,2,3,4]

    public static int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            }
            else if (sum < target) {
               l++;
            } else { // sum is greater than target.
                r--;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4};
        int target = 3;
        int[] res = twoSum(in, target);

        System.out.printf("Input array: %s target: %s and result: %s", List.of(in).toString(), target, List.of(res).toString() );

    }
}

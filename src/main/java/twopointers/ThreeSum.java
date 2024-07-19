package twopointers;
import java.util.*;

public class ThreeSum {

    // O(NLOGN
    // Solution: This is like a combination of two sum II and Two Sum on a sorted array.
    // Go through the entire array and for each value, consider it as the first number being added.
    // Then, use the two pointers technique in sorted two sum to close in on our target.
    // The array needs to be sorted for this to work.
    // Also, to filter out duplicate values we need to skip over them in the array when we see them, much like in subsets ii.
    // The tricky part here is that this has to be done in both the outer and inner loop.
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // in place sort algo.

        List<List<Integer>> toRet = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;


            while (l < r) { // stop trying if r is greater than nums.length or if l goes to i
                int sum = nums[l] + nums[r] + nums[i];

                if (sum == 0) {
                    toRet.add(List.of(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

            // skip over duplicates...
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }

        return toRet;
    }


    public static void main(String[] args) {
        int[] in = new int[] {0, 0, 0};
        List<List<Integer>> output = threeSum(in);

        System.out.printf("Input: %s\nFinal Result: %s", List.of(in), output);
    }
}

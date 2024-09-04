package binarySearch;

public class TargetRotatedArray {


    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;


        while (l <= r) {
            int m = (r - l) / 2 + l;

            if (nums[m] == target) return m;

            // We are currently in the left portion of the array.
            if (nums[m] >= nums[l]) {
                if (nums[m] < target || target < nums[l]) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
            // We are in the right portion of the array.
            else {
                if (nums[m] > target || target > nums[r]) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }

        }


        return -1;
    }


    public static void main(String[] args) {
        int[] in = {3,4,5,6,1,2};
        int target = 1;

        System.out.printf("Target is at index: %d", search(in, target));
    }
}

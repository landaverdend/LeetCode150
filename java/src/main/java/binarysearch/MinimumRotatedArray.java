package binarysearch;

public class MinimumRotatedArray {
    public static int findMin(int[] nums) {

        int l = 0; int r = nums.length - 1;
        int min = Integer.MAX_VALUE;

        // Do a check to see if the array is in original sorted order. No work required, just return L
        if (nums[l] < nums[r]) return nums[l];


        while (l <= r) {
            int m = (r - l) / 2 + l;
            min = Math.min(nums[m], min);

            if(nums[r] > nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return min;
    }


    public static void main(String[] args) {
        int[] in = new int[] {3,4,5,1,2};

        System.out.printf("Minimum is: %d", findMin(in));

    }
}

package binarysearch;

public class MedianTwoSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] small = nums1;
        int[] big = nums2;

        if (small.length > big.length) {
            int[] tmp = big;
            big = small;
            small = tmp;
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int l = 0;
        int r = small.length;

        while (l <= r) {
            int ms = (r - l) / 2 + l;
            int mb = half - ms; // The partition ends with however remaining spaces there are

            int smallLeft = ms > 0 ? small[ms - 1] : Integer.MIN_VALUE;
            int smallRight = ms < small.length ? small[ms] : Integer.MAX_VALUE;
            int bigLeft = mb > 0 ? big[mb - 1] : Integer.MIN_VALUE;
            int bigRight = mb < big.length ? big[mb] : Integer.MAX_VALUE;


            // We have found the dividing lines between partitions when each arrays ending left partition is less than the leading element of the other arrays right partition.
            if (smallLeft <= bigRight && bigLeft <= smallRight) {
                // When the array is of odd length, we want to just return the larger item on the left
                if (total % 2 != 0) {
                    return Math.max(bigLeft, smallLeft);
                }
                else {
                    return (double) (Math.max(smallLeft, bigLeft) + Math.min(smallRight, bigRight)) / 2;
                }
            } else if (smallLeft > bigRight) {
                r = ms - 1;
            } else {
                l = ms + 1;
            }

        }


        return -1;
    }

    public static void main(String[] args ) {
        int[] in1 = {1, 3};
        int[] in2 = { 2 };

        findMedianSortedArrays(in1, in2);
    }

}

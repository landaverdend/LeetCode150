package binarysearch;

import java.net.URISyntaxException;
import java.util.List;

public class BinarySearch {


    // nums is guaranteed to be already sorted in ascending order....
    public static int search(int[] arr, int target) {

        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = ((r - l) / 2) + l;

            if (arr[m] == target) return m;

            if (arr[m] < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws URISyntaxException {

        List<Integer> nums = List.of(1, 2);
        int[] intArray = nums.stream().mapToInt(Integer::intValue).toArray();

        int target = 3;
        System.out.println(String.format("Target: %d, Array: %s, Index: %d", target, nums, search(intArray, target) ));

    }
}

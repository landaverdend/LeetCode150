package binarySearch;

import common.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {


    // nums is guaranteed to be already sorted in ascending order....
    public static int search(int[] nums, int target) {


        int l = 0; int r = nums.length - 1;
        while (l <= r) {
           int m = l + ((r - l) / 2);
           // m is the target, back out..
           if (nums[m] == target) {
               return m;
           }
           // move the window to the left because nums[m] is too big
           else if (nums[m] > target) {
               r = m - 1;
           } else { // move the window right. nums[m] is too small
               l = m + 1;
           }

        }

        return -1;
    }

    public static void main(String[] args) throws URISyntaxException {

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int[] intArray = nums.stream().mapToInt(Integer::intValue).toArray();

        int target = 2;
        System.out.println(String.format("Target: %d, Array: %s, Index: %d", target, nums, search(intArray, target) ));

    }
}

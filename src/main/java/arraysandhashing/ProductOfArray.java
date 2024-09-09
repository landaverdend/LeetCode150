package arraysandhashing;

import java.util.List;

public class ProductOfArray {

    // prod = 1
    // 1 2 4 6 nums
    // 1 1 2 8 toRet
    // The idea here is to do it WITHOUT using the division operator, while using O(1) space
    public static int[] productExceptSelf(int[] nums) {
        int[] toRet = new int[nums.length];

        // Go through the array once and fill it with the products to the left
        toRet[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            toRet[i] = nums[i - 1] * toRet[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            toRet[i] = toRet[i] * R;
            R *= nums[i];
        }

        return toRet;
    }


    public static void main(String[] args ){
        int[] input = new int[] {1, 2, 4, 6};

        int[] result = productExceptSelf(input);

        System.out.printf("Input: %s Output: %s ", List.of(input), List.of(result));
    }
}

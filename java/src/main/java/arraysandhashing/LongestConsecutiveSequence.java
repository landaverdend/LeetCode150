package arraysandhashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {



    // Keep track of elements visited through a set. check if nums[i] - 1 is in the set, if so, then inc
    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num); // fill the set with all nums.

        int max = 0;

        for (int num: nums) {
            // If a smaller element doesn't exist, then we know for sure that this is the start of a sequence.
            if (!set.contains(num - 1)) {

                int currentElement = num;
                int currentStreak = 1;
                // increase the current element keep going until the streak has broken.
                while (set.contains(++currentElement)) {
                    currentStreak++;
                }

                max = Math.max(max, currentStreak);
            }
        }

        return max;
    }

    public static void main(String[] args) {


        int[] nums = { 5, 5, 6, 12,12323,233,44,45,6,46,47,48 };
        int longestSequence = longestConsecutive(nums);

        System.out.println(String.format("Longest sequence in %s is %d long", List.of(nums), longestSequence));

    }
}

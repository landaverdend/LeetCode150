package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class SubstringNoDupes {

    // Algorithm will run in O(N) time and will take O(N) space.
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>(); // keep track of the characters in the current substring.
        int l = 0, r = 0;
        int longest = 1;

        while (r < s.length()) {

            char c = s.charAt(r);
            // When we run into a character we've seen already, just clear the set and move the left pointer to r.
            while (seen.contains(c)) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(c);

            longest = Math.max(1 + (r - l), longest);
            r++;
        }

        return longest;
    }

    public static void main(String[] args) {
        String in = "a";

        System.out.printf("Length of longest substring with no duplicates in %s is %d", in, lengthOfLongestSubstring(in));
    }
}

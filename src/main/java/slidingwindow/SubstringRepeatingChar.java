package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubstringRepeatingChar {

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;

        while (r < s.length()) {

            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (((r - l) + 1) - getMax(map) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

       return max;
    }

    public static int getMax(Map<Character, Integer> map) {
        int max = 0;

        for (int val : map.values()) {
            max = Math.max(val, max);
        }

        return max;
    }

    public static void main(String[] args) {

        String in = "AAABABB";
        int k = 1;

        System.out.printf("Max string for input: %s is %d", in, characterReplacement(in, k));
    }
}

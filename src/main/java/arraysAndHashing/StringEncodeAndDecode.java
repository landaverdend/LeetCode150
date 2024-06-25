package arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {

    private static final String DELIMITER = "/:";

    // Naive Approach: Add a unicode character to separate each string and then when we read it we know where it is delimited...
    // Better: Use an 'escape' algorithm where you add something before each of your escape characters....
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            for (char c : str.toCharArray()) {
                // this is the delimiter for our escape. We need to prepend another / so that we know on the other side that it was originally in our string.
                // if you had the string '/:/:/:' it would look like by the time we have to decode it '//://://:'
                if (c == '/') {
                    sb.append("//");
                }
                else {
                    sb.append(c);
                }
            }

            sb.append(DELIMITER);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<StringBuilder> toRet = new ArrayList<>();

        char[] arr = str.toCharArray();
        int j = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            char c = arr[i];
            if (toRet.size() <= j) { // add a new string...
                toRet.add(new StringBuilder());
            }

            if (c == '/' && arr[i + 1] == '/' // we 'escaped' here in our encode algorithm.
            ) {
                toRet.set(j, toRet.get(j).append('/'));
                i++;
            }
            else if (c == '/' && arr[i + 1] == ':') {
                i++; // jump the next character. this is the delimiter...
                j++;
            }
            else { // all other cases....
                toRet.set(j, toRet.get(j).append(c));
            }

        }

        return toRet.stream().map(StringBuilder::toString).toList();

    }

    public static void main(String[] args) {
        List<String> in = List.of("", "");

        String encoded = encode(in);
        List<String> decoded = decode(encoded);
        System.out.printf("Input: %s Encoded: %s Decoded: %s ", in, encoded, decoded);

    }
}

package twopointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        String cleaned = cleanString(s);

        int l = 0; int r = s.length() - 1;

        while (l <= r) {

            if (cleaned.charAt(l) != cleaned.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static String cleanString(String s) {
        StringBuilder theString = new StringBuilder(s.toLowerCase());

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) theString.append(c);
        }

        return theString.toString();
    }

    public static void main(String[] args) {
        String str = "a";
        boolean result = isPalindrome(str);
        System.out.println(System.out.printf("String %s is palindrome ? %o", str, result ));

    }
}

package twopointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        String cleaned = cleanString(s);

        int l = 0; int r = cleaned.length() - 1;

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
        StringBuilder theString = new StringBuilder("");

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) theString.append(c);
        }

        return theString.toString().toLowerCase();
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(str);
        String r = result ? "true" : "false";
        System.out.println(System.out.printf("String %s is palindrome %s? ", str, r));

    }
}

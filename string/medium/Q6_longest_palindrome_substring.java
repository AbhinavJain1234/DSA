package string.medium;

public class Q6_longest_palindrome_substring {
    // brute force O(n^3)
    public static String fun(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // O(n^2) as we are iterating over all the substrings
    // and third n is for checking palindrome

    // two pointer approach
    public static String funop(String str) {
        if (str.length() <= 1)
            return str;

        String LPS = "";

        for (int i = 1; i < str.length(); i++) {

            // Consider odd length
            int low = i;
            int high = i;
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // Consider even length
            low = i - 1;
            high = i;
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }

    public static void main(String[] args) {
        System.out.println(fun("abcd"));
        System.out.println(funop("abcd"));
    }
}

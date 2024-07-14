package twopointer.medium;

public class Q2_longestsibstringwithnonrepeatingcharacter {
    public static int lengthOfLongestSubstring(String s) {
        int hash[] = new int[256];
        int maxLength = 0;
        int l = 0, r = 0;
        int n = s.length();
        while (r < n) {
            hash[s.charAt(r)]++;
            while (hash[s.charAt(r)] > 1) {
                hash[s.charAt(l)]--;
                l++;
            }
            if (hash[s.charAt(r)] == 1)
                maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }

    public static int length(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int hash[] = new int[256];
            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] == 1)
                    break;
                else {
                    hash[s.charAt(j)]++;
                }
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(length(s));
    }
}

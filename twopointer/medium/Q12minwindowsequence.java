package twopointer.medium;

public class Q12minwindowsequence {
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int start = -1;
        int minLen = Integer.MAX_VALUE;

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j == m) {
                    int end = i + 1;
                    j--;
                    while (j >= 0) {
                        if (s.charAt(i) == t.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j++;

                    if (end - i < minLen) {
                        minLen = end - i;
                        start = i;
                    }
                }
            }
        }

        return (start == -1) ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "dgfbkfibbkihjkaediegihhdjfaaedhdffaedcehhagedfjg";
        String t = "dde";
        System.out.println(minWindow(s, t));
    }

}

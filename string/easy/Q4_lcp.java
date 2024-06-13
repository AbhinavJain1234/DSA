package string.easy;

public class Q4_lcp {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            System.out.println(ch);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    if (i > 0)
                        return strs[j].substring(0, j);
                    else
                        return "";
                }
            }
        }
        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "" }));
    }
}

package string.medium;

public class Q5_substring {
    // o(n^2) as we are iterating over all the substrings
    public static int fun(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int freq = 0;
            int frq[] = new int[26];
            for (int j = i; j < n; j++) {
                if (frq[s.charAt(j) - 'a'] == 0) {
                    freq++;
                }
                frq[s.charAt(j) - 'a']++;
                if (freq == k) {
                    count++;
                }
            }
        }
        return count++;
    }

    // sliding window
    public static int calc(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int frq[] = new int[26];
        int res = 0;
        int dist = 0;
        while (j < n) {
            char ch = s.charAt(j);
            frq[ch - 'a']++;
            if (frq[ch - 'a'] == 1)
                dist++;
            while (dist > k) {
                frq[s.charAt(i) - 'a']--;
                if (frq[s.charAt(i) - 'a'] == 0)
                    dist--;
                i++;
            }
            j++;
            res = j - i + 1 + res;

        }
        return res;
    }

    public static int funop(String s, int k) {
        return calc(s, k) - calc(s, k - 1);
    }

    public static void main(String[] args) {
        System.out.println(funop("abaaca", 1));
        System.out.println(funop("aba", 2));
    }
}

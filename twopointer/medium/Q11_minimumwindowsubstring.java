package twopointer.medium;

public class Q11_minimumwindowsubstring {
    public String minWindowbrute(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = 0;
        int n = s.length();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            int count = 0;
            for (int j = 0; j < t.length(); j++) {
                hash[t.charAt(j)]++;
            }
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;

                if (count == t.length()) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        sIndex = i;
                        found = true;
                    }
                    break;
                }
            }
        }
        if (!found) {
            return "";
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(sIndex, sIndex + minLen);
    }

    public String minWindow(String s, String t) {
        int sIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int n = s.length(), m = t.length();
        if (n == 0 || m == 0)
            return "";
        int r = 0, l = 0;
        int hash[] = new int[256];
        for (int i = 0; i < m; i++)
            hash[t.charAt(i)]++;
        while (r < n) {
            char ch = s.charAt(r);
            if (hash[ch] > 0)
                count++;
            hash[ch]--;
            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                char ch2 = s.charAt(l);
                if (hash[ch2] == 0)
                    count--;
                hash[ch2]++;
                l++;
            }
            r++;
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(sIndex, sIndex + minLen);
    }
}

package twopointer.medium;

public class Q5_longestrepeatingcharacterwithreplacement {
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxL = 0, maxf = 0;
        int l = 0, r = 0;
        int hash[] = new int[26];
        while (r < n) {
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxf > k) {
                hash[s.charAt(l) - 'A']--;
                maxf = 0;
                for (int i = 0; i < 26; i++) {
                    maxf = Math.max(maxf, hash[i]);
                }
                l++;
            }
            if (r - l + 1 - maxf <= k)
                maxL = Math.max(maxL, (r - l + 1));
            r++;
        }
        return maxL;
    }

    public static int characterReplacementBrute(String s, int k) {
        int n = s.length();
        int maxL = 0, maxf = 0;
        for (int i = 0; i < n; i++) {
            int hash[] = new int[26];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxf = Math.max(maxf, hash[s.charAt(j) - 'A']);
                if ((j - i + 1) - maxf > k) {
                    break;
                } else {
                    maxL = Math.max(maxL, (j - i + 1));
                }
            }
        }
        return maxL;
    }
}

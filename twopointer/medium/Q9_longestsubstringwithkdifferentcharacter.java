package twopointer.medium;

import java.util.HashMap;

public class Q9_longestsubstringwithkdifferentcharacter {
    public int longestkSubstrbrute(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxlen = -1;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
                if (map.size() > k)
                    break;
                if (map.size() == k)
                    maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }

    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = s.length();
        int maxlen = -1;

        while (r < n) {
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }
            if (map.size() == k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }

        return maxlen;
    }

}
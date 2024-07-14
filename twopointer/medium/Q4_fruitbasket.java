package twopointer.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q4_fruitbasket {
    public static int totalFruits(int N, int[] fruits) {
        int l = 0, r = 0, maxFruits = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < N) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }

            maxFruits = Math.max(maxFruits, r - l + 1);
            r++;
        }

        return maxFruits;
    }

    public static int fruits(int N, int fruits[]) {
        int maxLen = 0;
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);
                if (set.size() > 2)
                    break;
                else
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] fruits = { 1, 2, 1, 2, 3 };
        System.out.println(totalFruits(N, fruits));
        System.out.println(fruits(N, fruits));
    }
}

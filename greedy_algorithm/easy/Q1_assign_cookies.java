package greedy_algorithm.easy;

import java.util.Arrays;

public class Q1_assign_cookies {
    public static int assignCookies(int[] greed, int[] s) {
        Arrays.sort(greed);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < greed.length && j < s.length) {
            if (greed[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(assignCookies(new int[] { 1, 5, 3, 3, 4 }, new int[] { 4, 2, 1, 2, 1, 3 }));
    }

}

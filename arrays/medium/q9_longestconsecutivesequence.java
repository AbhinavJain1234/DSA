package arrays.medium;


import java.util.Arrays;
import java.util.HashSet;

import arrays.easy.Q7_linearsearch;

public class q9_longestconsecutivesequence {
    public static int solBrute(int a[]) {
        int longest = 1;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            int count = 1;
            while (Q7_linearsearch.linearSearchB(a, x + 1) == true) {
                x++;
                count++;
            }
            if (count > longest)
                longest = count;
        }
        return longest;
    }

    public static int solBetter(int a[]) {
        Arrays.sort(a);
        int lastSmallest = Integer.MIN_VALUE;
        int longest = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] - 1 == lastSmallest) {
                count++;
                lastSmallest = a[i];
            } else if (a[i] != lastSmallest) {
                count = 1;
                lastSmallest = a[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public static int solOptimal(int a[]) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int a[] = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        System.out.println(solBrute(a));
        int b[] = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
        System.out.println(solBetter(b));
        System.out.println(solOptimal(a));
    }

}

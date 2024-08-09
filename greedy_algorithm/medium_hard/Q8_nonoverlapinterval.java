package greedy_algorithm.medium_hard;

import java.util.Arrays;

public class Q8_nonoverlapinterval {
    public static int eraseOverlapIntervals(int[][] interval) {
        Arrays.sort(interval, (a, b) -> (a[1] - b[1]));
        int count = 1;
        int limit = interval[0][1];
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] >= limit) {
                count++;
                limit = interval[i][1];
            }
        }
        return interval.length - count;
    }

    public static void main(String[] args) {
        int interval[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(interval));
    }
}

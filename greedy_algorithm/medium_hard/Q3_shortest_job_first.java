package greedy_algorithm.medium_hard;

import java.util.Arrays;

public class Q3_shortest_job_first {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int wait = 0;
        int total = 0;
        for (int i = 0; i < bt.length; i++) {
            total += wait;
            wait += bt[i];
        }
        int avg = total / bt.length;
        return avg;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 1, 4, 3, 2 }));
    }
}

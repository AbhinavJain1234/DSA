package dp.oned_dp;

public class climbing_stair {

    //memoization
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climbStairsHelper(n, dp);
    }

    private int climbStairsHelper(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];

        int oneStep = climbStairsHelper(n - 1, dp);
        int twoSteps = climbStairsHelper(n - 2, dp);

        dp[n] = oneStep + twoSteps;
        return dp[n];
    }

    //tabulation
    public int climbStairs2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //space optimization
    public int climbStairs3(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int oneStep = 1;
        int twoSteps = 1;
        int allSteps = 0;

        for (int i = 2; i < n + 1; i++) {
            allSteps = oneStep + twoSteps;
            twoSteps = oneStep;
            oneStep = allSteps;
        }

        return allSteps;
    }
}

package dp.aditya_verma.Zero_One_Knapsack;

class SubsetSum {
    public boolean subsefuntSum(int[] nums, int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] nums = { 1, 6, 11, 5 };
        System.out.println("The subset sum is: " + subsetSum.subsefuntSum(nums, 11, nums.length));
    }
}
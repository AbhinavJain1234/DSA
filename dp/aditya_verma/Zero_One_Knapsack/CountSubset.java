package dp.aditya_verma.Zero_One_Knapsack;
class CountSubset {
    public int subsefuntSum(int[] nums, int sum, int n) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++)
            dp[0][i] = 0;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        CountSubset countSubset = new CountSubset();
        int[] nums = { 1, 6, 11, 5 };
        int sum = 11;
        System.out.println("The subset sum is: " + countSubset.subsefuntSum(nums, sum, nums.length));
    }
}
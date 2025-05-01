package dp.aditya_verma.Zero_One_Knapsack;
class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums)sum+=ele;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=sum;i++)dp[0][i]=false;
        for(int i=0;i<=n;i++)dp[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }else dp[i][j]=dp[i-1][j];
            }
        }
         int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i]) {
                min = Math.min(min, sum - 2 * i);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 6, 11, 5};
        System.out.println("The minimum difference is: " + solution.minimumDifference(nums));
    }
}
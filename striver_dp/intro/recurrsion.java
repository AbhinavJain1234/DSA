
package striver_dp.intro;

public class recurrsion {
    public int fibbonaciRecursion(int n) {
        if(n== 0) return 0;
        if(n== 1) return 1;
        return fibbonaciRecursion(n-1) + fibbonaciRecursion(n-2);
    }

    public int fibbonaciMemoization(int n, int[] dp) {
        if(n== 0) return 0;
        if(n== 1) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibbonaciMemoization(n-1, dp) + fibbonaciMemoization(n-2, dp);
        return dp[n];
    }

    public int fibbonaciTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int fibbonaciSpaceOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev2 = 0, prev1 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
    public static void main(String[] args) {
        recurrsion obj = new recurrsion();
        System.out.println(obj.fibbonaciRecursion(5)); // Output: 5
        int n = 5;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1; // Initialize memoization array
        }
        System.out.println(obj.fibbonaciMemoization(n, dp)); // Output: 5
        System.out.println(obj.fibbonaciTabulation(n)); // Output: 5
        System.out.println("Fibonacci of 5 using recursion: " + obj.fibbonaciRecursion(5));
        System.out.println("Fibonacci of 5 using memoization: " + obj.fibbonaciMemoization(5, dp));
        System.out.println("Fibonacci of 5 using tabulation: " + obj.fibbonaciTabulation(5));
    }
}

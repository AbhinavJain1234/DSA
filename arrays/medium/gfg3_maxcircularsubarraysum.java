package arrays.medium;


public class gfg3_maxcircularsubarraysum {
    public static int maxCircularSubarraySumBrute(int[] arr) {
        int n = arr.length;
        int maxSum = arr[0];

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currentSum += arr[index];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static int maxCircularSubarraySumOptimal(int[] arr) {
        int n = arr.length;
        int maxNormal = normalMaxSum(arr, n); // Changed variable name to camelCase
        if (maxNormal < 0)
            return maxNormal;

        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxCircular = arrSum + normalMaxSum(arr, n); // Changed variable name to camelCase
        return Math.max(maxCircular, maxNormal); // Changed variable name to camelCase
    }

    public static int normalMaxSum(int[] arr, int n) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 8, -4, 3, -5, 4 };
        System.out.println("Maximum circular subarray sum: " + maxCircularSubarraySumBrute(arr));
        System.out.println("Maximum circular subarray sum: " + maxCircularSubarraySumOptimal(arr));
    }
}

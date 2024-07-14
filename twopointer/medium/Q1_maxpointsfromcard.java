package twopointer.medium;

public class Q1_maxpointsfromcard {

    // my approach
    public static int maxPoint(int arr[], int k) {
        int windowSum = 0;
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < n - k; i++) {
            windowSum += arr[i];
        }

        int minSum = windowSum;
        for (int i = n - k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - n + k];
            minSum = Math.min(minSum, windowSum);
        }
        return sum - minSum;
    }

    // striver approach
    public static int maxScore(int[] nums, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            lsum += nums[i];
        }
        maxSum = lsum;
        int rindex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum -= nums[i];
            rsum += nums[rindex];
            rindex--;
            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(maxPoint(arr, k));
        System.out.println(maxScore(arr, k));
    }
}

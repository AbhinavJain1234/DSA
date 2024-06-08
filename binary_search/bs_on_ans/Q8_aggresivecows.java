package binary_search.bs_on_ans;

import java.util.Arrays;

public class Q8_aggresivecows {

    public static int aggresivecowslinear(int arr[], int cows) {
        int n = arr.length;
        int limit = arr[n - 1] - arr[0];
        for (int i = 1; i <= limit; i++) {
            if (isPossible(arr, cows, i)) {
                continue;
            } else
                return i - 1;
        }
        return -1;
    }

    public static boolean isPossible(int arr[], int cows, int distance) {
        int n = arr.length;
        int count = 1;
        int lastpos = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastpos >= distance) {
                count++;
                lastpos = arr[i];
            }
        }
        return count >= cows;
    }

    public static int aggresivecowsbs(int arr[], int cows) {
        int n = arr.length;
        int high = arr[n - 1] - arr[0];
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 3, 4, 7, 10, 9 };
        Arrays.sort(arr);
        System.out.println(aggresivecowslinear(arr, 4));
        System.out.println(aggresivecowsbs(arr, 4));
    }
}
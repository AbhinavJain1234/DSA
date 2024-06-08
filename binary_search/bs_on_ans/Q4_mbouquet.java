package binary_search.bs_on_ans;

public class Q4_mbouquet {

    public static boolean bno(int arr[], int day, int m, int k) {
        int n = arr.length;
        int maxbno = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                count++;

            } else {
                count = 0;
            }
            if (count == k) {
                count = 0;
                maxbno++;
            }

        }
        return maxbno >= m;
    }

    public static int mbouquetllinear(int arr[], int m, int k) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n)
            return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        for (int i = mini; i <= maxi; i++) {
            if (bno(arr, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    public static int mbouquetoptimal(int arr[], int m, int k) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n)
            return -1; // Impossible case.
        // Find maximum and minimum:
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bno(arr, mid, m, k)) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int k = 3;
        int m = 2;
        int ans = mbouquetoptimal(arr, m, k);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

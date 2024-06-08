package binary_search.bs_on_ans;

public class Q5_smallestdivisorwiththreshold {

    public static boolean divisior(int arr[], int t, int d) {
        System.out.println();
        int n = arr.length;
        int div = 0;
        for (int i = 0; i < n; i++) {
            div += Math.ceil((double) arr[i] / d);
        }
        return div <= t;
    }

    public static int smallestdivisorwiththresholdlinear(int arr[], int t) {
        int n = arr.length;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        for (int i = 1; i <= maxi; i++) {
            if (divisior(arr, t, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int smallestdivisorwiththresholdoptimal(int arr[], int t) {
        int n = arr.length;
        if (t < n)
            return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (divisior(arr, t, mid)) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String arg[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int limit = 8;
        int ans = smallestdivisorwiththresholdoptimal(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}

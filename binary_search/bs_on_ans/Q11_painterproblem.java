package binary_search.bs_on_ans;

//same as splitarraylargestsum
public class Q11_painterproblem {
    public static int sumlinear(int arr[], int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        for (int i = max; i <= sum; i++) {
            if (isPossible(arr, k, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPossible(int arr[], int k, int sum) {
        int n = arr.length;
        int count = 1;
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (s > sum) {
                count++;
                s = arr[i];
            }
        }
        return count <= k;
    }

    public static int sumbs(int arr[], int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 2, 5, 10, 8 };
        System.out.println(sumlinear(arr, 2));
        System.out.println(sumbs(arr, 2));
    }
}

package binary_search.bs_on_ans;

public class Q9_bookallocation {
    public static int bookallocationlinear(int arr[], int students) {
        int n = arr.length;
        if (n < students) {
            return -1;
        }
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        for (int i = max; i <= sum; i++) {
            if (isPossible(arr, students, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPossible(int arr[], int students, int pages) {
        int n = arr.length;
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > pages) {
                count++;
                sum = arr[i];
            }
        }
        return count <= students;
    }

    public static int bookallocationbs(int arr[], int students) {
        int n = arr.length;
        if (n < students) {
            return -1;
        }
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        while (max <= sum) {
            int mid = max + (sum - max) / 2;
            if (isPossible(arr, students, mid)) {
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int arr[] = { 25, 46, 28, 49, 24 };
        System.out.println(bookallocationlinear(arr, 4));
        System.out.println(bookallocationbs(arr, 4));
    }
}

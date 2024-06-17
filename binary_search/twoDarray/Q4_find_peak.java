package binary_search.twoDarray;

public class Q4_find_peak {

    // brute O(n*m*4)
    public static int findPeakBrute(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                boolean flag = true;
                if (i > 0 && arr[i][j] < arr[i - 1][j])
                    flag = false;
                if (i < n - 1 && arr[i][j] < arr[i + 1][j])
                    flag = false;
                if (j > 0 && arr[i][j] < arr[i][j - 1])
                    flag = false;
                if (j < m - 1 && arr[i][j] < arr[i][j + 1])
                    flag = false;
                if (flag)
                    return arr[i][j];
            }
        }
        return -1;
    }

    // better for worst case is to find largest element
    public static int findPeakBetter(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

    // optimal O(n*log(m))
    public static int findPeakOptimal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, arr[i][mid]);
            }
            if (mid > 0 && max < arr[mid - 1][mid]) {
                high = mid - 1;
            } else if (mid < m - 1 && max < arr[mid + 1][mid]) {
                low = mid + 1;
            } else {
                return max;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        System.out.println(findPeakBrute(arr));
        System.out.println(findPeakBetter(arr));
        System.out.println(findPeakOptimal(arr));
    }
}

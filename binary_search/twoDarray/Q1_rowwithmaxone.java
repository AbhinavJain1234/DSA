package binary_search.twoDarray;

public class Q1_rowwithmaxone {
    public static int ansbrute(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int maxCount = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }

    public static int ansoptimal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int maxCount = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int low = 0;
            int high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[i][mid] == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count = m - low;
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        System.out.println(ansbrute(arr));
        System.out.println(ansoptimal(arr));
    }
}

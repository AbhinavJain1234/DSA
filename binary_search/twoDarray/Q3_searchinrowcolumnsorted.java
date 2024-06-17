package binary_search.twoDarray;

public class Q3_searchinrowcolumnsorted {
    public static boolean searchMatrixOptimalCase2(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int col = m - 1, row = 0;
        while (col >= 0 && row < n) {
            if (arr[row][col] == target)
                return true;
            else if (arr[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        System.out.println(searchMatrixOptimalCase2(arr, 29));
    }
}

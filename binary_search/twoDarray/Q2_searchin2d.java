package binary_search.twoDarray;

import java.util.ArrayList;
import java.util.Arrays;

public class Q2_searchin2d {
    public static boolean searchMatrixBrute(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size(), m = matrix.get(0).size();

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == target)
                    return true;
            }
        }
        return false;
    }

    // better
    public static boolean binarySearch(ArrayList<Integer> nums, int target) {
        int n = nums.size(); // size of the array
        int low = 0, high = n - 1;

        // Perform the steps:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) == target)
                return true;
            else if (target > nums.get(mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static boolean searchMatrixBetter(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(0) <= target && target <= matrix.get(i).get(m - 1)) {
                return binarySearch(matrix.get(i), target);
            }
        }
        return false;
    }

    // optimal
    public static boolean searchMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix.get(mid / m).get(mid % m) == target)
                return true;
            else if (matrix.get(mid / m).get(mid % m) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

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
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

        boolean result = searchMatrixBrute(matrix, 8);
        System.out.println(result);
        System.out.println(searchMatrixBetter(matrix, 8));
        System.out.println(searchMatrixOptimal(matrix, 8));
        System.out.println(searchMatrixOptimalCase2(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 14));

    }
}

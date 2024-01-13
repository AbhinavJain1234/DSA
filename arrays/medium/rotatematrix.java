package medium;

import java.util.Arrays;

public class rotatematrix {
    static int[][] solBrute(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void solOptimal(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(a[i]);
        }
    }

    static void reverse(int a[]) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int rotated[][] = solBrute(arr);
        System.out.println("Rotated Image");
        for (int[] row : rotated)
            System.out.println(Arrays.toString(row));
        int arr2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solOptimal(arr2);
        for (int[] row : arr2)
            System.out.println(Arrays.toString(row));
    }
}
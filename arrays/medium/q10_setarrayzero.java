package arrays.medium;


import java.util.Arrays;

public class q10_setarrayzero {
    public static void solBrute(int a[][]) {
        int n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    markRow(i, a);
                    markColumn(j, a);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
    }

    static void markRow(int x, int a[][]) {
        for (int i = 0; i < a[0].length; i++) {
            if (a[x][i] != 0) {
                a[x][i] = -1;
            }
        }
    }

    static void markColumn(int x, int a[][]) {
        for (int i = 0; i < a[0].length; i++) {
            if (a[i][x] != 0) {
                a[i][x] = -1;
            }
        }
    }

    public static void solBetter(int a[][]) {
        int n = a.length, m = a[0].length;
        int markedRow[] = new int[n], markedColumn[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    markedRow[i] = 1;
                    markedColumn[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (markedRow[i] == 1 || markedColumn[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
    }

    public static void solOptimal(int a[][]) {
        int n = a.length, m = a[0].length;
        int col = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    if (j == 0)
                        col = 0;
                    else
                        a[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] != 0) {
                    if (a[i][0] == 0 || a[0][j] == 0) {
                        a[i][j] = 0;
                    }
                }
            }
        }
        if (a[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                a[0][j] = 0;
            }
        }
        if (col == 0) {
            for (int i = 0; i < n; i++) {
                a[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }

    public static void main(String[] args) {
        int c[][] = { { 1, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };
        solBrute(c);
        int b[][] = { { 1, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };
        solBetter(b);
        int a[][] = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
        solOptimal(a);
        int d[][] = { { 1, 1, 1, }, { 1, 0, 1, }, { 1, 1, 1 } };
        solOptimal(d);
    }

}

// done better with arraylist
// import java.util.*;

// public class tUf {
// static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>>
// matrix, int n, int m) {
// int[] row = new int[n]; // row array
// int[] col = new int[m]; // col array

// // Traverse the matrix:
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (matrix.get(i).get(j) == 0) {
// // mark ith index of row wih 1:
// row[i] = 1;

// // mark jth index of col wih 1:
// col[j] = 1;
// }
// }
// }

// // Finally, mark all (i, j) as 0
// // if row[i] or col[j] is marked with 1.
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (row[i] == 1 || col[j] == 1) {
// matrix.get(i).set(j, 0);
// }
// }
// }

// return matrix;
// }

// public static void main(String[] args) {
// ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
// matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
// matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
// matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

// int n = matrix.size();
// int m = matrix.get(0).size();

// ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

// System.out.println("The Final matrix is: ");
// for (ArrayList<Integer> row : ans) {
// for (Integer ele : row) {
// System.out.print(ele + " ");
// }
// System.out.println();
// }
// }
// }

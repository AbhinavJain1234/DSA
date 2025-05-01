package arrays.easy;

import java.util.Arrays;

public class Q5b_rightrotatebydplace {
    static void rightRotateByDPlaceBrute(int a[], int d) {
        int n = a.length;
        d = d % n;
        // storing in temp
        int temp[] = new int[d];
        for (int i = n - d; i < n; i++)
            temp[i - (n - d)] = a[i];
        // shifting right
        for (int i = n - 1; i >= d; i--)
            a[i] = a[i - d];
        System.out.println(Arrays.toString(a));
        // putting temp back
        for (int i = 0; i < d; i++)
            a[i] = temp[i];
    }

    static void rightRotateByDPlaceOptimal(int a[], int d) {
        int n = a.length;
        d = d % n;
        reverse(a, 0, n - d - 1);
        reverse(a, n - d, n - 1);
        reverse(a, 0, n - 1);
    }

    static void reverse(int a[], int x, int y) {
        while (x <= y) {
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
            x++;
            y--;
        }

    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        rightRotateByDPlaceOptimal(a, 3);
        System.out.println(Arrays.toString(a));
    }

}

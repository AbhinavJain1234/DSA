package easy;

import java.util.Arrays;

public class Q5_leftrotatebydplaces {

    static void leftRotateByDPlaceBrute(int a[], int d) {
        int n = a.length;
        d = d % n;
        // storing in temp
        int temp[] = new int[d];
        for (int i = 0; i < d; i++)
            temp[i] = a[i];
        // shifting left
        for (int i = d; i < n; i++)
            a[i - d] = a[i];
        // putting temp back
        for (int i = n - d; i < n; i++)
            a[i] = temp[i - (n - d)];
    }

    static void leftRotateByDPlaceOptimal(int a[], int d) {
        int n = a.length;
        d = d % n;
        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
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
        leftRotateByDPlaceOptimal(a, 1);
        System.out.println(Arrays.toString(a));
    }

}

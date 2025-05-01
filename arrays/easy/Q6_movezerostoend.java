package arrays.easy;

import java.util.Arrays;

public class Q6_movezerostoend {

    static void moveZerosToEndBrute(int a[]) {
        int n = a.length;
        int temp[] = new int[n];
        int j = 0;
        // stored elements int temp
        for (int i : a)
            if (i != 0)
                temp[j++] = i;
        // we directly copy temp to a as last unfilled slots of temp is 0 by
        // default(initial value)
        for (int i = 0; i < temp.length; i++)
            a[i] = temp[i];
    }

    // 2 pointer approach
    static void moveZerosToEndOptimal(int a[]) {
        int n = a.length;
        int j = -1;
        // locating first zero
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }
        // return if whole array is non zero
        if (j == -1) {
            System.out.println("No zeros");
            return;
        }
        // if we find non zero then swap with a[j]
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                swap(a, j, i);
                j++;
            }
        }
    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 0, 3, 0, 4, 0, 5 };
        moveZerosToEndBrute(a);
        System.out.println(Arrays.toString(a));
        int b[] = { 1, 2, 0, 3, 0, 4, 0, 5, 0, 0, 9, 8, 7, 6, 5 };
        moveZerosToEndOptimal(b);
        System.out.println(Arrays.toString(b));
    }
}

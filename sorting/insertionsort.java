package sorting;

import java.util.Arrays;

public class insertionsort {

    // normal
    static void insertionSort(int a[]) {
        int l = a.length;
        for (int i = 1; i < l; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    // recursion
    // sort the left array then swap the element to its right place
    static void insertionSortRecursion(int a[], int n) {
        if (n == 0)
            return;
        insertionSortRecursion(a, n - 1);
        int i = n;
        while (i > 0 && a[i] < a[i - 1]) {
            swap(a, i, i - 1);
            i--;
        }
    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 14, 9, 15, 12, 6, 8, 13 };
        insertionSort(a);
        System.out.println(Arrays.toString(a));
        int b[] = { 14, 9, 15, 12, 6, 8, 13 };
        insertionSortRecursion(b, b.length - 1);
        System.out.println(Arrays.toString(b));
    }
}
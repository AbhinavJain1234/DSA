package easy;

import java.util.Arrays;

public class quicksort {

    // Ascending
    public static void quickSort(int a[], int low, int high) {
        if (low < high) {
            // System.out.println(Arrays.toString(a)); //to see arrray in each recursion
            int partition = findPartition(a, low, high);
            quickSort(a, low, partition - 1);
            quickSort(a, partition + 1, high);
        }
    }

    static int findPartition(int a[], int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];
        while (i < j) {
            while (a[i] <= pivot && i < high)// i<high if we put equal to it will show index out of bound
                i++; // a[i]>=pivot but a[j]<pivot not equals as we will put equal only on one side
                     // of piovt otherwise error
            while (a[j] > pivot && j > low)// j>low if we put equal to it will show index out of bound
                j--;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    // desending

    static void quickSortD(int a[], int low, int high) {
        if (low < high) {
            // System.out.println(Arrays.toString(a));// to see arrray in each recursion
            int partition = findPartitionD(a, low, high);
            quickSortD(a, low, partition - 1);
            quickSortD(a, partition + 1, high);
        }
    }

    static int findPartitionD(int a[], int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];
        while (i < j) {
            while (a[i] >= pivot && i < high)// i<high if we put equal to it will show index out of bound
                i++; // a[i]>=pivot but a[j]<pivot not equals as we will put equal only on one side
                     // of piovt otherwise error
            while (a[j] < pivot && j > low)// j>low if we put equal to it will show index out of bound
                j--;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 2, 5, 4, 6, 4, 7, 9, 1, 3 };
        // quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        quickSortD(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}

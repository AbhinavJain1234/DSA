package medium;

import java.util.Arrays;

import sorting.mergesort;

public class q2_sortarrayofzerosonesandtwos {

    // brute
    public static void solBrute(int a[]) {
        mergesort.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    // better
    public static void solBetter(int a[]) {
        int countZeros = 0, countOnes = 0, countTwos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                countZeros++;
            else if (a[i] == 1)
                countOnes++;
            else
                countTwos++;
        }
        int i = 0;
        for (; i < countZeros; i++) {
            a[i] = 0;
        }
        for (; i < countOnes + countZeros; i++) {
            a[i] = 1;
        }
        for (; i < countTwos + countOnes + countZeros; i++) {
            a[i] = 2;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void solOptimal(int a[]) {
        int low = 0, mid = 0;
        int high = a.length - 1;
        while (high >= mid) {
            if (a[mid] == 0) {
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1)
                mid++;
            else {
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
        solBrute(a);
        int b[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
        solBetter(b);
        int c[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
        solOptimal(c);
    }
}

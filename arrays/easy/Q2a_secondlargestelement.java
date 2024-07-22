package easy;

import java.util.*;

public class Q2a_secondlargestelement {
    static int secondLargestBrute(int a[]) {
        Arrays.sort(a);
        int n = a.length - 2;
        while (a[a.length - 1] == a[n] && n > 0)
            n--;
        if (a[a.length - 1] != a[n])
            return a[n];
        else
            return -1;
    }

    static int secondLargestBetter(int a[]) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (largest < a[i])
                largest = a[i];
        }
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (secondLargest < a[i] && a[i] < largest)
                secondLargest = a[i];
        }
        return secondLargest;
    }

    static int secondLargestBest(int a[]) {
        int largest = a[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (largest < a[i]) {
                secondLargest = largest;
                largest = a[i];
            } else if (largest > a[i] && secondLargest < a[i])
                secondLargest = a[i];
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int a[] = { 9, 5, 4, 3, 7, 9 };
        System.out.println(secondLargestBetter(a));
        System.out.println(secondLargestBest(a));
        System.out.println(secondLargestBrute(a));
    }

}

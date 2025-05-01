package arrays.easy;


public class Q1_largestelement {
    static int largestOptimized(int a[]) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (largest < a[i])
                largest = a[i];
        }
        return largest;
    }

    static int largestBrute(int a[]) {
        quicksort.quickSort(a, 0, a.length - 1);
        return a[a.length - 1];
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 4, 3, 7, 9 };
        System.out.println(largestOptimized(a));
        System.out.println(largestBrute(a));
    }

}

public class smallestelement {
    static int smallestOptimized(int a[]) {
        int smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest > a[i])
                smallest = a[i];
        }
        return smallest;
    }

    static int smallestBrute(int a[]) {
        quicksort.quickSort(a, 0, a.length - 1);
        return a[0];
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 4, 3, 7, 9 };
        System.out.println(smallestOptimized(a));
        System.out.println(smallestBrute(a));
    }
}

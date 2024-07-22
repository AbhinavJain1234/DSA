package recursion.kunal.patterns;

public class selectionsort {
    static void fun(int arr[], int r, int c, int max) {
        if (r == 0) // Corrected base case
            return;
        if (c <= r) {
            if (arr[c] > arr[max]) {
                max = c;
            }
            fun(arr, r, c + 1, max);
        } else {
            int temp = arr[r];
            arr[r] = arr[max];
            arr[max] = temp;
            fun(arr, r - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 4, 5, 4, 3, 2, 1 };
        fun(arr, arr.length - 1, 0, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

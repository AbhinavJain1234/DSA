package recursion.kunal.patterns;

public class bubblesort {
    void fun(int arr[], int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            fun(arr, r, c + 1);
        } else {
            fun(arr, r - 1, 0);
        }
    }

    public static void main(String[] args) {
        bubblesort b = new bubblesort();
        int arr[] = { 5, 4, 3, 2, 1 };
        b.fun(arr, arr.length - 1, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

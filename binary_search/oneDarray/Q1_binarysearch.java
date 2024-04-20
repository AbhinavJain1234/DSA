package binary_search.oneDarray;

public class Q1_binarysearch {
    public static int binarySearchIterative(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int arr[], int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] < x) {
            return binarySearchRecursive(arr, mid + 1, high, x);
        }
        return binarySearchRecursive(arr, low, mid - 1, x);
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(binarySearchIterative(a, 5));
        System.out.println(binarySearchRecursive(a, 0, a.length - 1, 5));
    }
}
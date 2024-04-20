package binary_search.oneDarray;

public class Q3_upperbound {
    public static int upperBound(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= x) {
                index = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        return index;
    }

    public static int upperBound2(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        int index = arr.length;// return lenght of array if no element is greater than x
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > x) {
                index = m;
                r = m - 1;
            } else
                l = m + 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(upperBound(a, -10));
        System.out.println(upperBound2(a, 4));
    }

}
package binary_search.oneDarray;

public class Q5_floorandceil {
    public static int ceil(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        int index = arr.length;// return lenght of array if no element is greater than x
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= x) {
                index = m;
                r = m - 1;
            } else
                l = m + 1;
        }
        return index;
    }

    public static int floor(int arr[], int x) {
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

    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 7 };
        System.out.println(ceil(a, 3));
        System.out.println(floor(a, 3));
    }

}

package binary_search.oneDarray;

public class Q13_findpeak {
    public static int findinMultiplePeakElement(int[] a) {
        int n = a.length;
        if (n == 1)
            return 0;
        if (a[0] > a[1])
            return 0;
        if (a[n - 1] > a[n - 2])
            return n - 1;
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return mid;
            else if (a[mid] > a[mid - 1])
                low = mid + 1;
            else if (a[mid] > a[mid + 1])
                high = mid - 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int findPeakElement(int[] a) {
        int n = a.length;
        if (n == 1)
            return 0;
        if (a[0] > a[1])
            return 0;
        if (a[n - 1] > a[n - 2])
            return n - 1;
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return mid;
            else if (a[mid] > a[mid - 1])
                low = mid + 1;
            else if (a[mid] > a[mid + 1])
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int b[] = { 1, 3, 1, 3, 1 };
        System.out.println(findPeakElement(a));
        System.out.println(findinMultiplePeakElement(b));
    }
}

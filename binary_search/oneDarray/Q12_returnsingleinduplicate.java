package binary_search.oneDarray;

public class Q12_returnsingleinduplicate {
    public static int singleNonDuplicate(int[] a) {
        int n = a.length;
        if (n == 1)
            return a[0];
        if (a[0] != a[1])
            return a[0];
        if (a[n - 1] != a[n - 2])
            return a[n - 1];
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1])
                return a[mid];
            else if ((a[mid] == a[mid - 1] && mid % 2 == 1) || (a[mid] == a[mid + 1] && mid % 2 == 0))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(a));
    }
}

package binary_search.oneDarray;

public class Q10_findminimumisrotatedarray {
    public static int findMin(int[] a) {
        int low = 0;
        int n = a.length;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[low] <= a[high]) {// extra optimisation
                ans = Math.min(ans, a[low]);
                break;
            }
            if (a[mid] >= a[low]) {
                if (ans >= a[low])
                    ans = a[low];
                low = mid + 1;
            } else {
                if (ans >= a[mid])
                    ans = a[mid];
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findMinDuplicates(int[] a) {
        int low = 0;
        int n = a.length;
        int high = n - 1;
        int ans = a[0]; // Initialize ans to the first element

        while (low <= high) {
            // Check if the array is already sorted
            if (a[low] < a[high]) {
                ans = Math.min(ans, a[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Handle duplicates
            if (a[mid] == a[low] && a[mid] == a[high]) {
                low++;
                high--;
                continue;
            }

            // Check which half of the array contains the minimum element
            if (a[mid] >= a[low]) {
                if (ans >= a[low])
                    ans = a[low];
                low = mid + 1;
            } else {
                if (ans >= a[mid])
                    ans = a[mid];
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(a));
        int b[] = { 2, 2, 2, 0, 1 };
        System.out.println(findMinDuplicates(b));
    }
}

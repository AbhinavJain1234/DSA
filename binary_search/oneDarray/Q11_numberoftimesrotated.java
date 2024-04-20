
package binary_search.oneDarray;

public class Q11_numberoftimesrotated {
    public static int rotation(int[] a) {
        int low = 0;
        int n = a.length;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        if (a[low] <= a[high]) {// extra optimisation
            ans = Math.min(ans, a[low]);
            index = low;
            return index;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= a[low]) {
                if (ans >= a[low]) {
                    ans = a[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (ans >= a[mid]) {
                    ans = a[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
        System.out.println(rotation(a));
    }

}
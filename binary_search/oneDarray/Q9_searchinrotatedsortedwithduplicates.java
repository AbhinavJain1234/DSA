package binary_search.oneDarray;

public class Q9_searchinrotatedsortedwithduplicates {
    public static int search(int a[], int target) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] == a[low] && a[mid] == a[high]) {
                low++;
                high--;
                continue;
            }
            if (a[mid] >= a[low]) {
                if (target >= a[low] && target <= a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= a[mid] && target <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 6, 0, 0, 1, 2 };
        System.out.println(search(a, 0));
    }
}
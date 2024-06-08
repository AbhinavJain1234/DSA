package binary_search.bs_on_ans;

public class Q7_kthmissingnumber {
    public static int missingbrute(int arr[], int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    public static int missingoptimal(int arr[], int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (low + k);
    }

    public static void main(String[] args) {
        System.out.println(missingbrute(new int[] { 2, 3, 4, 7, 11 }, 5));
        System.out.println(missingoptimal(new int[] { 2, 3, 4, 7, 11 }, 5));
    }
}

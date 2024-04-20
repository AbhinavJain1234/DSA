package binary_search.oneDarray;

public class Q6_firstlastoccurance {

    // this is direct binary search implementation by stiver
    public static int[] searchRange(int[] nums, int target) {
        int index[] = { -1, -1 };
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    index[0] = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        if (index[0] == -1)// this save log n time
            return index;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target)
                    index[1] = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10 };
        int ans[] = searchRange(a, 3);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

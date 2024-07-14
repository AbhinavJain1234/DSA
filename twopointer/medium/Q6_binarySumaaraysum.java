package twopointer.medium;

public class Q6_binarySumaaraysum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums, goal) - fun(nums, goal - 1);
    }

    public static int fun(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int r = 0, l = 0, n = nums.length, sum = 0, count = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}

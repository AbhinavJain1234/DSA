package twopointer.medium;

import java.util.HashMap;

public class Q7_nicesubarray {
    public static int numberOfSubarrays(int[] nums, int goal) {
        int n = nums.length;
        int[] bin = new int[n];
        for (int i = 0; i < n; i++) {
            bin[i] = nums[i] % 2;
        }
        return fun(bin, goal) - fun(bin, goal - 1);
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

    public int numberOfSubarraysBrute(int[] nums, int k) {
        int n = nums.length;
        int[] bin = new int[n];
        for (int i = 0; i < n; i++) {
            bin[i] = nums[i] % 2;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // There is one way to have a sum of 0 (by not including any elements)

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sum += bin[i];
            if (countMap.containsKey(sum - k)) {
                count += countMap.get(sum - k);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}

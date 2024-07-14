package twopointer.medium;

public class Q3_maxconsecutiveones {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxCount = 0;
        int n = nums.length;
        int zerosCount = 0;
        while (r < n) {
            if (nums[r] == 0)
                zerosCount++;
            while (zerosCount > k) {
                if (nums[l] == 0)
                    zerosCount--;
                l++;
            }
            if (zerosCount <= k) {
                maxCount = Math.max(maxCount, r - l + 1);
            }
            r++;
        }
        return maxCount;
    }
}

package twopointer.medium;

import java.util.HashMap;

public class Q10_subarrayswithkdifferentinteger {
    public int subarraysWithKDistinctBrute(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                int currentChar = nums[j];
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
                if (map.size() > k)
                    break;
                if (map.size() == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return (fun(nums, k) - fun(nums, k - 1));
    }

    static int fun(int[] nums, int k) {
        int r = 0, l = 0, n = nums.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            int currentChar = nums[r];
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            while (map.size() > k) {
                int leftChar = nums[l];
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }

}

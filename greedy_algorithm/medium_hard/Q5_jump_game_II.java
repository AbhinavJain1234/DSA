package greedy_algorithm.medium_hard;

public class Q5_jump_game_II {
    // brute force usinf recursion
    public static int jump(int[] nums, int jumps, int index) {
        if (index >= nums.length - 1)
            return jumps;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, jump(nums, jumps + 1, index + i));
        }
        return min;
    }

    // dp

    // greedy-as we want to go the fartest
    public static int jumpss(int nums[]) {
        int n = nums.length;
        int jumps = 0;
        int r = 0, l = 0;
        while (r < n - 1) {
            int fartest = 0;
            for (int i = l; i <= r; i++) {
                fartest = Math.max(fartest, i + nums[i]);
            }
            l = r + 1;
            r = fartest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }, 0, 0));
        System.out.println(jumpss(new int[] { 2, 3, 1, 1, 4 }));
    }
}

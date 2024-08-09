package greedy_algorithm.medium_hard;

public class Q4_jump_game_I {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
    }
}

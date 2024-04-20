package easy;

public class gfg2_maximumdiffernence {
    public static int findMaximumDifferenceBrute(int[] a) {
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                maxDiff = Math.max(maxDiff, a[j] - a[i]);
            }
        }
        return maxDiff;
    }

    // similar to stock buy sell logic done in medium

    public static int findMaximumDifferenceOptimal(int[] a) {
        int min = a[0];
        int difference = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            difference = Math.max(difference, a[i] - min);
            min = Math.min(min, a[i]);
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 5, 1, 3, 5 };
        int maxDifference = findMaximumDifferenceBrute(arr);
        System.out.println("Maximum Difference: " + maxDifference);
        System.out.println("Maximum Difference: " + findMaximumDifferenceOptimal(arr));
    }
}

import java.util.*;

class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int i = 0, j = 0;
        int n = candidates.length;
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        // while (j < n) {
        // for (int k = i; k <= j; k++) {
        // System.out.print(candidates[k] + " ");
        // }
        // System.out.println();
        // System.out.println("sum " + sum);
        // if (sum == target) {
        // j++;
        // i++;
        // System.out.println("herray");
        // // ArrayList<Integer> tempList = new ArrayList<>();
        // // for (int k = i; k <= j; k++) {
        // // tempList.add(candidates[k]);
        // }
        // // list.add(tempList);
        // // Resetting sum and moving the window to find new combinations
        // // j++;
        // else if (sum > target) {
        // sum -= candidates[i];
        // i++;
        // } else {
        // sum += candidates[j];
        // j++;
        // }
        // }
        while (j < n) {
            if (sum + candidates[j] <= target) {
                sum += candidates[j];
                j++;
            } else {
                sum -= candidates[i];
                i++;
            }
            if (sum == target) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    tempList.add(candidates[k]);
                }
                list.add(tempList);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };// 1 1 2 5 6 7 10
        int target = 8;
        List<List<Integer>> list = combinationSum2(arr, target);

        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
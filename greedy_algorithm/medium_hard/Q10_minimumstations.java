package greedy_algorithm.medium_hard;

import java.util.Arrays;

public class Q10_minimumstations {
    public static int minStation(int arr[], int dept[]) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0, j = 0;
        int n = arr.length;
        int count = 0;
        int maxCount = 0;
        while (i < n) {
            if (arr[i] <= dept[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dept[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(minStation(arr, dept));
    }
}

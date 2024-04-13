package medium;

import java.util.Arrays;
import java.util.HashMap;

public class q1_twosum {

    // brute variety 1
    static boolean twoSumBrute(int a[], int sum) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == sum)
                    return true;
            }
        }
        return false;
    }

    // brute variety 2
    // static boolean twoSumBrute(int a[], int sum) {
    // int[] ans = new int[2];
    // ans[0] = ans[1] = -1;
    // for (int i = 0; i < a.length - 1; i++) {
    // for (int j = i + 1; j < a.length; j++) {
    // if (a[i] + a[j] == sum){
    // a[0]=i;a[1]=j;
    // return ans
    // }
    // }
    // }
    // return ans;
    // }

    // // better variety 1

    // static boolean twoSumBetter(int a[], int sum) {
    // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // for (int i = 0; i < a.length; i++) {
    // if (map.containsValue(sum - a[i])) {
    // return true;
    // } else
    // map.put(a[i], i);
    // }
    // return false;
    // }

    // optimal variety 2 (it was better for variety 1)
    public static int[] twoSumBetter(int a[], int sum) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int moreNeeded = sum - num;
            if (map.containsKey(moreNeeded)) {
                ans[0] = i;
                ans[1] = map.get(moreNeeded);
                return ans;
            } else
                map.put(a[i], i);
        }
        return ans;
    }

    // optimal variety 1
    public static boolean twoSumOptimal(int a[], int sum) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1;
        while (i < j) {
            int temp = a[i] + a[j];
            if (temp == sum)
                return true;
            else if (temp < sum)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = { 2, 6, 5, 8, 11 };
        System.out.println(twoSumBrute(a, 14));
        int ans[] = twoSumBetter(a, 14);
        System.out.println(Arrays.toString(ans));
        System.out.println(twoSumOptimal(a, 14));
    }

}

package recursion.kunal.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allsubsets {
    public void subset(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        subset(s.substring(1), ans + s.charAt(0));
        subset(s.substring(1), ans);
    }

    public void subset(String s, String ans, ArrayList<String> res) {
        if (s.length() == 0) {
            res.add(ans);
            return;
        }
        subset(s.substring(1), ans + s.charAt(0), res);
        subset(s.substring(1), ans, res);
    }

    public ArrayList<String> subsets(String s, String ans) {
        if (s.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(ans);
            return base;
        }
        ArrayList<String> smallans = subsets(s.substring(1), ans + s.charAt(0));
        ArrayList<String> smallans2 = subsets(s.substring(1), ans);
        smallans.addAll(smallans2);
        return smallans;
    }

    // subset with ascii
    public void subsetwithascii(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        subsetwithascii(s.substring(1), ans + s.charAt(0));
        subsetwithascii(s.substring(1), ans + (int) s.charAt(0));
        subsetwithascii(s.substring(1), ans);
    }

    // usinf loops
    public void subsetusingloops(String s) {
        int n = s.length();
        for (int i = 0; i < (1 << n); i++) {
            String ans = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    ans += s.charAt(j);
                }
            }
            System.out.println(ans);
        }
    }

    // using loops in arraylist
    public ArrayList<String> subsetusingloopswithreturn(String s) {
        int m = s.length();
        ArrayList<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < m; i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                res.add(res.get(j) + s.charAt(i));
            }
        }
        return res;
    }

    // subsets when it contains duplicates [1,2,2]
    public void subsetWithDuplicates(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = res.size() - 1;
            int m = res.size();
            for (int j = start; j < m; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        allsubsets as = new allsubsets();
        as.subset("abc", "");
        ArrayList<String> res = new ArrayList<>();
        as.subset("abc", "", res);
        System.out.println(res);
        as.subsets("abc", "").forEach(value -> {
            System.out.print(value + " ");
        });
        System.out.println();
        as.subsetwithascii("abc", "");
        // as.subsetusingloops("abc");
        System.out.println(as.subsetusingloopswithreturn("abc"));
        as.subsetWithDuplicates(new int[] { 1, 2, 2, 3 });

    }
}

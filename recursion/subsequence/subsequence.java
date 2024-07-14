package recursion.subsequence;

import java.util.ArrayList;

public class subsequence {

    public static void fun(int arr[], int index, ArrayList<Integer> ans) {
        if (index == arr.length) {
            System.out.println(ans);
            return;
        }
        ans.add(arr[index]);
        fun(arr, index + 1, ans);
        ans.remove(ans.size() - 1);
        fun(arr, index + 1, ans);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        fun(arr, 0, new ArrayList<>());
    }
}
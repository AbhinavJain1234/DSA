package recursion.kunal.arrays;

import java.util.ArrayList;

public class linearsearch {

    public static boolean search(int[] arr, int index, int target) {
        if (index == arr.length) {
            return false;
        }
        if (arr[index] == target) {
            return true;
        } else {
            return search(arr, index + 1, target);
        }
    }

    public static void search(int[] arr, int index, int target, ArrayList<Integer> ans) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            ans.add(index);
        }
        search(arr, index + 1, target, ans);
    }

    public static ArrayList<Integer> searchList(int[] arr, int index, int target, ArrayList<Integer> ans) {
        if (index == arr.length) {
            return ans;
        }
        if (arr[index] == target) {
            ans.add(index);
        }
        return searchList(arr, index + 1, target, ans);
    }

    public static ArrayList<Integer> searchList(int[] arr, int index, int target) {
        if (index == arr.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = searchList(arr, index + 1, target);
        if (arr[index] == target) {
            ans.add(index);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 4, 5 };
        System.out.println(search(arr, 0, 3));
        ArrayList<Integer> ans = new ArrayList<>();
        search(arr, 0, 4, ans);
        System.out.println(ans);
        System.out.println(searchList(arr, 0, 4, new ArrayList<>()));
        System.out.println(searchList(arr, 0, 4));

    }
}

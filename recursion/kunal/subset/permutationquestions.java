package recursion.kunal.subset;

import java.util.ArrayList;

public class permutationquestions {
    public static void permutations(String s, String p) {
        if (s.length() == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 0; i <= p.length(); i++) {
            permutations(s.substring(1), p.substring(0, i) + s.charAt(0) + p.substring(i));
        }
    }

    public static ArrayList<String> permutationss(String s, String p) {
        if (s.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(p);
            return base;
        }
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            temp.addAll(permutationss(s.substring(1), p.substring(0, i) + s.charAt(0) + p.substring(i)));
        }
        return temp;
    }

    public static int count(String s, String p) {
        if (s.length() == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            count += count(s.substring(1), p.substring(0, i) + s.charAt(0) + p.substring(i));
        }
        return count;
    }

    // permutation in array
    public static void permutations(int[] arr, int i) {
        if (i == arr.length) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            permutations(arr, i + 1);
            swap(arr, i, j);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        permutations("abcaah", "");
        System.out.println(permutationss("abc", ""));
        System.out.println(count("abcde", ""));
        permutations(new int[] { 1, 2, 3 }, 0);
    }
}

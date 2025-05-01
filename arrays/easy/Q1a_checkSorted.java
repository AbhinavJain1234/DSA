package arrays.easy;

public class Q1a_checkSorted {
    // brute,better,bestdd
    static boolean checkIfSorted(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8 };
        System.out.println(checkIfSorted(a));
        System.out.println(checkIfSorted(b));
    }
}
package easy;

import java.util.*;

public class union {

    // brute
    static int[] unionBrute(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);
        for (int i = 0; i < b.length; i++)
            set.add(b[i]);
        int unionSet[] = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            unionSet[i++] = it.next();
        }
        return unionSet;
    }

    // optimal- 2 pointer
    static ArrayList<Integer> unionOptimal(int a[], int b[]) {
        int i = 0, j = 0, n = a.length, m = b.length;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.getLast() != a[i]) {
                    union.add(a[i++]);
                } else {
                    if (union.size() == 0 || union.getLast() != b[j]) {
                        union.add(b[j++]);
                    }
                }

            }
        }
        while (i < n) {
            if (union.size() == 0 || union.getLast() != a[i]) {
                union.add(a[i++]);
            }

        }
        while (j < m) {
            if (union.size() == 0 || union.getLast() != b[j]) {
                union.add(b[j++]);
            }

        }

        return union;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6 };
        int b[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(unionBrute(a, b)));
        System.out.println(unionOptimal(a, b).toString());
    }
}

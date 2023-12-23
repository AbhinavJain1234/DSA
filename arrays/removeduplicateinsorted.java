import java.util.*;

public class removeduplicateinsorted {

    //for unsorted array we can create a temp array and then change og array and return index
    // can use this method to remove in unsorted array
    static int removeDuplicateInSortedBrute(int a[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        int j = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            a[j++] = it.next();
        }
        return set.size() - 1;

    }

    static int removeDuplicateInSortedOptimized(int a[]) {
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9 };
        int index = removeDuplicateInSortedBrute(a);
        System.out.print("[" + a[0]);
        for (int i = 1; i <= index; i++) {
            System.out.print("," + a[i]);
        }
        System.out.println("]");
        int b[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9 };
        index = removeDuplicateInSortedOptimized(b);
        System.out.print("[" + b[0]);
        for (int i = 1; i <= index; i++) {
            System.out.print("," + b[i]);
        }
        System.out.print("]");
    }
}

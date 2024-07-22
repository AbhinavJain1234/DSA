package easy;

import java.util.*;

public class Q8_union {

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
    static ArrayList<Integer> unionOptimal(int arr1[], int arr2[]) {
        int i = 0, j = 0, n = arr1.length, m = arr2.length;
        ArrayList<Integer> Union = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6 };
        int b[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(unionBrute(a, b)));
        System.out.println(unionOptimal(a, b).toString());
    }
}

package arrays.medium;


import java.util.HashMap;
import java.util.Map;

public class q3_majorityelement {
    public static int solBrute(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j])
                    count++;
            }
            if (count > a.length / 2)
                return a[i];
        }
        return -1;
    }

    public static int solBetter(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int value = map.getOrDefault(a[i], 0);
            map.put(a[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (a.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    public static int solOptimal(int a[]) {
        int element = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                element = a[i];
                count = 1;
            } else if (element == a[i])
                count++;
            else if (element != a[i])
                count--;
        }

        int tempCount = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == element)
                tempCount++;

        if (tempCount > a.length / 2)
            return element;
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 2, 2, 3, 3, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        System.out.println(solBrute(a));
        System.out.println(solBetter(a));
        System.out.println(solOptimal(a));
    }

}

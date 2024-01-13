package medium;

import java.util.ArrayList;

public class leaderinarray {
    public static ArrayList<Integer> solBrute(int a[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int flag = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                list.add(a[i]);
        }
        return list;
    }

    public static ArrayList<Integer> solOptimal(int a[]) {
        ArrayList<Integer> list = new ArrayList<>();
        // int maxElement=Integer.MIN_VALUE;
        int n = a.length;
        int maxElement = a[n - 1];
        list.add(a[n - 1]);
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > maxElement) {
                list.add(a[i]);
                maxElement = a[i];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int a[] = { 10, 22, 12, 3, 0, 6 };
        System.out.println(solBrute(a));
        System.out.println(solOptimal(a));
    }

}

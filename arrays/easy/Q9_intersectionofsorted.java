package arrays.easy;

import java.util.ArrayList;

public class Q9_intersectionofsorted {

    // brute force
    static ArrayList<Integer> intersectionBrute(int a[], int b[]) {
        int visited[] = new int[b.length];
        ArrayList<Integer> intersectedArray = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] && visited[j] == 0) {
                    visited[j] = 1;
                    intersectedArray.add(a[i]);
                    break;
                }
                if (b[j] > a[i])
                    break;
            }
        }
        return intersectedArray;
    }

    // optimal
    // two pointer approach
    static ArrayList<Integer> intersectionOptiomal(int a[], int b[]) {
        ArrayList<Integer> intersectedArray = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                intersectedArray.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j])
                i++;
            else if (b[j] < a[i])
                j++;
        }
        return intersectedArray;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int b[] = { 2, 3, 3, 5, 6, 6, 7 };

        System.out.println(intersectionBrute(a, b));
        System.out.println(intersectionOptiomal(a, b));
    }

}

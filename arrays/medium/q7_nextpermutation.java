package medium;

import java.util.Arrays;

public class q7_nextpermutation {
    // only optimal
    public static void solOptimal(int a[]) {
        int index = -1;
        int n = a.length;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < a.length / 2; i++) {
                int temp = a[i];
                a[i] = a[a.length - i - 1];
                a[a.length - i - 1] = temp;
            }
        } else {
            for (int i = n - 1; i >= index; i--) {
                if (a[i] > a[index]) {
                    int temp = a[i];
                    a[i] = a[index];
                    a[index] = temp;
                    break;
                }
            }
            for (int i = 1; i <= (n - index - 1) / 2; i++) {
                int temp = a[i + index];
                a[i + index] = a[n - i];
                a[n - i] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 3, 2, 1, 6, 5, 4 };
        solOptimal(a);
    }
}

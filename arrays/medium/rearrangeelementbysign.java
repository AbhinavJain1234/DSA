package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class rearrangeelementbysign {
    public static void solbrute(int a[]) {
        int pos[] = new int[a.length / 2];
        int posi = 0;
        int neg[] = new int[a.length / 2];
        int negi = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                pos[posi++] = a[i];
            else
                neg[negi++] = a[i];
        }
        for (int i = 0; i < a.length / 2; i++) {
            a[2 * i] = pos[i];
            a[2 * i + 1] = neg[i];
        }
        System.out.println(Arrays.toString(a));
    }

    public static void solOptimal(int a[]) {
        int ans[] = new int[a.length];
        int i = 0, j = 1;
        for (int index = 0; index < a.length; index++) {
            if (a[index] > 0) {
                ans[i] = a[index];
                i += 2;
            }

            else {
                ans[j] = a[index];
                j += 2;
            }

        }
        System.out.println(Arrays.toString(ans));
    }

    // if no of positive and negative are not equal
    public static void solFollowUp(int a[]) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                pos.add(a[i]);
            else
                neg.add(a[i]);
        }
        int posl = pos.size();
        int negl = neg.size();
        if (posl > negl) {
            int i = 0;
            for (; i < negl; i++) {
                a[2 * i] = pos.get(i);
                a[2 * i + 1] = neg.get(i);
            }
            for (int j = negl; j < posl; j++) {
                a[negl + j] = pos.get(j);
            }
        } else {
            int i = 0;
            for (; i < posl; i++) {
                a[2 * i] = pos.get(i);
                a[2 * i + 1] = neg.get(i);
            }
            for (int j = posl; j < negl; j++) {
                a[posl + j] = neg.get(j);
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        {
            int a[] = { 3, 1, -2, -5, 2, -4 };
            solbrute(a);
            int b[] = { 3, 1, -2, -5, 2, -4 };
            solOptimal(b);
            int c[] = { 1, -2, -3, -4, 3, -1 };
            solFollowUp(c);
        }
    }

}

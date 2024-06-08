package binary_search.bs_on_ans;

import java.util.ArrayList;

public class Q14_kthelementin2sortedarray {

    public static double kthelementBrute(int n1[], int n2[], int k) {
        int n1len = n1.length;
        int n2len = n2.length;
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1len && j < n2len) {
            if (n1[i] < n2[j]) {
                arr.add(n1[i]);
                i++;
            } else {
                arr.add(n2[j]);
                j++;
            }
        }
        while (i < n1len) {
            arr.add(n1[i]);
            i++;
        }
        while (j < n2len) {
            arr.add(n2[j]);
            j++;
        }
        return arr.get(k - 1);
    }

    public static int kthbetter(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        k--;
        int cnt = 0;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == k)
                    return a[i];
                cnt++;
                i++;
            } else {
                if (cnt == k)
                    return b[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == k)
                return a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == k)
                return b[j];
            cnt++;
            j++;
        }
        return 0;
    }

    public static int kthmissingnumberOptimal(int a[], int b[], int k) {

        int n1 = a.length;
        int n2 = b.length;
        // if n1 is bigger swap the arrays:
        if (n1 > n2)
            return kthmissingnumberOptimal(b, a, k);

        int n = n1 + n2;
        int left = k;
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = { 100, 112, 256, 349, 770 };
        int b[] = { 72, 86, 113, 119, 265, 445, 892 };
        int k = 7;
        System.out.println(kthmissingnumberOptimal(a, b, k));
        System.out.println(kthelementBrute(a, b, k));
        System.out.println(kthbetter(a, b, k));
    }
}

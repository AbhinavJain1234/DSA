package binary_search.bs_on_ans;

import java.util.ArrayList;

public class Q13_medianof2sortedarray {
    public static double findMedianBrute(int n1[], int n2[]) {
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
        int sum = n1len + n2len;
        if (sum % 2 == 0) {
            return (arr.get(sum / 2) + arr.get(sum / 2 - 1)) / 2.0;
        } else
            return arr.get(sum / 2);
    }

    public static double findMedianbetter(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        int cnt = 0;
        int ind1 = (n1 + n2) / 2 - 1, ind2 = (n1 + n2) / 2;
        int ind1el = -1, ind2el = -1;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1)
                    ind1el = a[i];
                if (cnt == ind2)
                    ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1)
                    ind1el = b[j];
                if (cnt == ind2)
                    ind2el = b[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == ind1)
                ind1el = a[i];
            if (cnt == ind2)
                ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1)
                ind1el = b[j];
            if (cnt == ind2)
                ind2el = b[j];
            cnt++;
            j++;
        }
        if ((n1 + n2) % 2 == 1) {
            return (double) ind2el;
        }

        return (double) ((double) (ind1el + ind2el)) / 2.0;

    }

    public static double findMedianOptimal(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        // if n1 is bigger swap the arrays:
        if (n1 > n2)
            return findMedianOptimal(b, a);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = { 1, 4, 7, 10, 12 };
        int[] b = { 2, 3, 6, 15 };
        System.out.println(findMedianBrute(a, b));
        System.out.println(findMedianbetter(a, b));
        System.out.println(findMedianOptimal(a, b));
    }
}

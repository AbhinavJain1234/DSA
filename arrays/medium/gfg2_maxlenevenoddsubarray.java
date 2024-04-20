package medium;

public class gfg2_maxlenevenoddsubarray {
    public static int maxEvenOdd(int arr[], int n) {
        int res = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if ((arr[i] % 2 != arr[i - 1] % 2)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = { 12, 10, 8, 4 };
        System.out.println(maxEvenOdd(a, a.length));
    }
}

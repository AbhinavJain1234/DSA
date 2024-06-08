package binary_search.bs_on_ans;

public class Q2_nthrootofm {
    // brute force-linear search O(mlog(n))
    public static int nthrootofmbrute(int m, int n) {
        int ans = -1;
        for (int i = 1; i <= m; i++) {
            if (Math.pow(i, n) == m)
                ans = i;
        }
        return ans;
    }

    // binary search O(log(m)log(n))
    public static int nthrootofmoptimal(int m, int n) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int power = func(mid, n, m);
            if (power == 1) {
                return mid;
            } else if (power == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int func(int mid, int n, int m) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m)
                return -1;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int m = 81, n = 4;
        System.out.println(nthrootofmbrute(m, n));
        System.out.println(nthrootofmoptimal(m, n));
    }
}

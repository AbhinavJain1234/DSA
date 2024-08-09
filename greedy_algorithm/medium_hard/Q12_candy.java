package greedy_algorithm.medium_hard;

public class Q12_candy {
    // brute
    public static int brute(int r[]) {
        int n = r.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (r[i] > r[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (r[i] > r[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    // better
    public static int better(int r[]) {
        int n = r.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (r[i] > r[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int cur = 1, right = 1, sum = Math.max(left[n - 1], right);
        for (int i = n - 2; i >= 0; i--) {
            if (r[i] > r[i + 1]) {
                cur = right + 1;
                right = cur;
            } else {
                right = 1;
                cur = 1;
            }
            sum += Math.max(cur, left[i]);
        }
        return sum;
    }

    // optimal slope approach
    public static int optimal(int[] rating) {
        int n = rating.length;
        int i = 1;
        int sum = 1;
        while (i < n) {
            if (rating[i] == rating[i - 1]) {
                sum += 1;
                i++;
            }
            int peak = 1;
            while (i < n && rating[i] > rating[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < n && rating[i] < rating[i - 1]) {
                sum += down;
                down++;
                i++;
            }
            if (down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int r[] = { 0, 2, 4, 7, 6, 5, 4, 3, 2, 1, 1, 1, 2, 3, 4, 2, 1, 1, 1 };
        System.out.println(brute(r));
        System.out.println(better(r));
        System.out.println(optimal(r));
    }

}

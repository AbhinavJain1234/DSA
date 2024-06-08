package binary_search.bs_on_ans;

public class Q3_kokobanana {
    // linear
    public static int kokobananalinear(int[] v, int h) {
        int i = 1;
        while (true) {
            int totalH = calculateTotalHours(v, i);
            if (totalH <= h)
                return i;
            i++;
        }
    }

    // optimal
    public static int kokobananaoptimal(int[] v, int h) {
        int low = 1, high = findMax(v);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(v, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int calculateTotalHours(int[] v, int k) {
        int totalH = 0;
        for (int i = 0; i < v.length; i++) {
            totalH += Math.ceil((double) (v[i]) / (double) (k));
        }
        return totalH;
    }

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        ;
        int n = v.length;
        // find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int piles[] = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        System.out.println(kokobananalinear(piles, h));
        System.out.println(kokobananaoptimal(piles, h));
    }
}

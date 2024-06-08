package binary_search.bs_on_ans;

public class Q1_findsqrt {
    public static int findsqrtbrute(int x) {
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            if (i * i <= x)
                ans = i;
            else
                break;
        }
        return ans;
    }

    // use Maht.sqrt() function

    public static int findsqrtfun(int x) {
        return (int) Math.sqrt(x);
    }

    // optimal solution using binary search
    public static int findsqrtoptimal(int x) {
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int x = 28;
        System.out.println(findsqrtbrute(x));
        System.out.println(findsqrtoptimal(x));
    }
}
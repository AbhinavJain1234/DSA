package string.medium;

public class Q7_sumofbeauty {

    // tc -o(n^2) as beuty is con tant as it run only fpor 26 times
    // sc is const 26
    public static int fun(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int frq[] = new int[26];
            for (int j = i; j < n; j++) {
                frq[s.charAt(j) - 'a']++;
                sum += beauty(frq);
            }
        }
        return sum;
    }

    public static int beauty(int frq[]) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (frq[i] > 0) {
                max = Math.max(max, frq[i]);
                min = Math.min(min, frq[i]);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(fun("aabcbaa"));
    }
}

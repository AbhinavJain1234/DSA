package recursion.stonghold;

public class count_good {

    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long count = countGood(n);
        return (int) count;
    }

    private long countGood(long n) {
        long powerOf5 = (n + 1) / 2;
        long powerOf4 = n / 2;

        long result = modExp(5, powerOf5, MOD) * modExp(4, powerOf4, MOD) % MOD;
        return result;
    }

    private long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}

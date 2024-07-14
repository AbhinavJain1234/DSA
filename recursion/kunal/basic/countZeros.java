package recursion.kunal.basic;

public class countZeros {
    public static int count(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 10) {
            return 0;
        }
        int lastDigit = n % 10;
        return (lastDigit == 0 ? 1 : 0) + count(n / 10);
    }

    public static void main(String[] args) {
        int n = 1; // Change this to the desired value
        System.out.println(count(n));
    }
}

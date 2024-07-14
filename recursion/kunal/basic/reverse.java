package recursion.kunal.basic;

public class reverse {
    public static int reversee(int n) {
        if (n < 10) {
            return n;
        } else {
            int lastDigit = n % 10;
            int remainingDigits = n / 10;
            return lastDigit * (int) Math.pow(10, (int) Math.log10(remainingDigits) + 1) + reversee(remainingDigits);
        }
    }

    public static void main(String[] args) {
        int n = 12345; // Change this to the desired value
        System.out.println(reversee(n));
    }
}

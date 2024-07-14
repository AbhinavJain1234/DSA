package recursion.kunal.basic;

public class productofdigit {
    public static int productOfDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            int lastDigit = num % 10;
            int remainingDigits = num / 10;
            return lastDigit * productOfDigits(remainingDigits);
        }
    }

    public static void main(String[] args) {
        int num = 12305; // Change this to the desired value
        System.out.println(productOfDigits(num));
    }
}

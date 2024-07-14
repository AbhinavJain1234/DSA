package recursion.kunal.basic;

public class sumofdigits {
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        } else {
            return number % 10 + sumOfDigits(number / 10);
        }
    }

    public static void main(String[] args) {
        int number = 12345; // Change this to the desired value
        System.out.println(sumOfDigits(number));
    }
}

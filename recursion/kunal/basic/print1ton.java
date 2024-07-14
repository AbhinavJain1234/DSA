package recursion.kunal.basic;

public class print1ton {
    public static void printNumbers(int n) {
        if (n <= 0) {
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10; // Change this to the desired value
        printNumbers(n);
    }
}

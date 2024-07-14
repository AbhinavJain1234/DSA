package recursion.kunal.basic;

public class sum {
    public static int sumOfN(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumOfN(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5; // Change this to the desired value
        System.out.println(sumOfN(n));
    }
}

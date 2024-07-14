package recursion.kunal.basic;

public class factorial {
    public static int factoriall(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factoriall(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5; // Change this to the desired value
        System.out.println(factoriall(n));
    }
}

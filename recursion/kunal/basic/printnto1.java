package recursion.kunal.basic;

public class printnto1 {
    public static void printNto1(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printNto1(n - 1);
    }
}

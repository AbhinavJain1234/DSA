package recursion.kunal.patterns;

public class patter2 {
    void fun(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            fun(r, c + 1);
            System.out.print("*");
        } else {
            fun(r - 1, 0);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        patter2 p = new patter2();
        System.out.println("Pattern 2:");
        p.fun(5, 0);
    }
}

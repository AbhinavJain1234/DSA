package recursion.kunal.patterns;

public class pattern1 {
    void fun(int n) {
        if (n == 0)
            return;
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        fun(n - 1);
    }

    void fun(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print("*");
            fun(r, c + 1);
        } else {
            System.out.println();
            fun(r - 1, 0);
        }
    }

    public static void main(String[] args) {
        pattern1 p = new pattern1();
        p.fun(5);
        p.fun(5, 0);
    }
}

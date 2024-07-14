package bitmanupilation.learning;

public class binary_conversion {

    public static String d2b(int n) {
        String res = "";
        while (n > 0) {
            res = n % 2 + res;
            n = n / 2;
        }
        return res;
    }

    public static int b2d(String s) {
        int res = 0;
        int pow = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                res = res + pow;
            pow = pow * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(d2b(n));
        String s = "1010011";
        System.out.println(b2d(s));
        System.out.println(-1073741825 << 1);
    }
}

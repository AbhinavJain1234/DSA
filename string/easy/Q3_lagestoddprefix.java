package string.easy;

public class Q3_lagestoddprefix {
    public static String fun(String a) {
        for (int i = a.length() - 1; i >= 0; i--) {
            if ((a.charAt(i) - 48) % 2 == 0) {
                return a.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(fun("52"));
    }
}

package recursion.kunal.subset;

public class removea {
    static String fun(String s, int i) {
        if (i == s.length()) {
            return "";
        }
        if (s.charAt(i) == 'a') {
            return fun(s, i + 1);
        }
        return s.charAt(i) + fun(s, i + 1);
    }

    static void fun(String s, String neww) {
        if (s.length() == 0) {
            System.out.println(neww);
            return;
        }
        if (s.charAt(0) == 'a') {
            fun(s.substring(1), neww);
        } else
            fun(s.substring(1), neww + s.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println(fun("abcadef", 0));
        fun("abcadef", "");
    }
}

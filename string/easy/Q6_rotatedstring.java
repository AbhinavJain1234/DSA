package string.easy;

public class Q6_rotatedstring {
    public static boolean fun(String a, String b) {
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                System.out.println(i);
                for (int j = 0; j < a.length(); j++) {
                    char ch = a.charAt((i + j) % a.length());
                    char ch2 = b.charAt(j);
                    System.out.println(ch + " " + ch2);
                    if (ch == ch2) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }

            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String a = "clrwmpkwru";
        String b = "wmpkwruclr";
        System.out.println(fun(a, b));
    }
}

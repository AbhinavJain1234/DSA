package string.medium;

public class Q4_atoi {

    public static int myAtoi(String s) {

        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;

        int sum = 0;
        int sign = 1;
        boolean started = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ' && !started) {
                continue;
            } else if (c == '-' && !started) {
                sign = -1;
                started = true;
            } else if (c == '+' && !started) {
                started = true;
            } else if (c >= '0' && c <= '9') {
                int digit = c - '0';
                if (sum > (INT_MAX - digit) / 10) {
                    return sign == 1 ? INT_MAX : INT_MIN;
                }
                sum = sum * 10 + digit;
                started = true;
            } else {
                break;
            }
        }

        return sum * sign;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }
}

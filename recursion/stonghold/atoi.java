package recursion.stonghold;

class atoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        return sign * convert(s, index, 0, sign);
    }

    private int convert(String s, int index, int result, int sign) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return result;
        }

        int digit = s.charAt(index) - '0';

        // Handle overflow
        if (sign == 1 && result > (Integer.MAX_VALUE - digit) / 10) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < (Integer.MIN_VALUE + digit) / 10) {
            return Integer.MIN_VALUE;
        }

        // Recursive step: process the next character
        return convert(s, index + 1, result * 10 + digit, sign);
    }
}

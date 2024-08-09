package greedy_algorithm.easy;

public class Q11_valid_parenthesis {
    // recursion
    public static boolean checkRecursion(String s, int index, int count) {
        if (count < 0)
            return false;
        if (index == s.length())
            return count == 0;
        if (s.charAt(index) == '(')
            return checkRecursion(s, index + 1, count + 1);
        else if (s.charAt(index) == ')')
            return checkRecursion(s, index + 1, count - 1);
        else
            return checkRecursion(s, index + 1, count + 1) || checkRecursion(s, index + 1, count - 1)
                    || checkRecursion(s, index + 1, count);
    }

    public static boolean check(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min = Math.max(min - 1, 0);
                max--;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
            if (max < 0)
                return false;
        }
        return min == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkRecursion("(**(", 0, 0));
        System.out.println(check("(**("));
    }
}

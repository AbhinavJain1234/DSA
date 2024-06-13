package string.easy;

import java.util.Stack;

public class Q1_removeouterparenthesis {

    // my approach using string but string is immutable so it is not efficient T.C.
    // is O(n^2) S.C. is O(n)
    public static void fun(String s) {
        int count = 0;
        int lastzeroindex = -1;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else
                count--;
            System.out.println(count);
            if (count == 0) {
                System.out.println(s.substring(lastzeroindex + 2, i));
                ans += s.substring(lastzeroindex + 2, i);
                lastzeroindex = i;
            }
        }
        System.out.println(ans);
    }

    // we use stringbuilder to make it efficient T.C. is O(n) S.C. is O(n)
    public String removeOuterParentheses(String s) {
        int count = 0;
        int start = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count == 0) {
                    start = i; // mark the start of a primitive
                }
                count++;
            } else {
                count--;
                if (count == 0) {
                    ans.append(s, start + 1, i); // exclude the outer parentheses
                }
            }
        }

        return ans.toString();

    }

    // stack approach T.C. is O(n) S.C. is O(n)
    public String removeOuterParenthesesstack(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    ans.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        fun("(()())(())");
    }
}

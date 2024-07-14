package stacks_and_queues.gfg;

import java.util.Stack;

public class validParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (ch) {
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') { // Corrected here
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}

package linked_list.mediumproblemll;

import java.util.Stack;

import linked_list.Node;

public class Q6_pallidrome {
    public boolean isPalindromeBrute(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            int a = stack.pop();
            if (temp.data != a)
                return false;
            temp = temp.next;
        }
        return true;
    }
}

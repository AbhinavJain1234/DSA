package linked_list.mediumproblemll;

import linked_list.Node;
import java.util.*;

public class Q5_reversell {
    public static Node reversebrute(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node reverseIterative(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = reverseRecursive(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }
}

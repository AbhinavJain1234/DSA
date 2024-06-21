package linked_list.mediumproblemll;

import linked_list.Node;

public class Q7_add1 {
    public static Node addOne(Node head) {
        head = reverseIterative(head);
        int carry = 1;
        Node temp = head;
        while (temp != null) {
            temp.data = carry + temp.data;
            if (temp.data < 10) {
                carry = 0;
                break;
            }
            temp.data = temp.data % 10;
            carry = 1;
            temp = temp.next;
        }
        if (carry == 1) {
            Node newNode = new Node(carry);
            head = reverseIterative(head);
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        head = reverseIterative(head);
        return head;
    }

    public static Node addOneRecursive(Node head) {
        int carry = helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static int helper(Node head) {
        if (head == null) {
            return 1;
        }
        int carry = helper(head.next);
        head.data += carry;
        if (head.data < 10) {
            return 0;
        } else {
            head.data = head.data % 10;
            return 1;
        }
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
}

package linked_list.mediumproblemll;

import linked_list.Node;

public class Q13_deleteMiddle {

    public static Node middleNodeBrute(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2;
        temp = head;

        while (temp != null) {
            mid = mid - 1;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        Node next = temp.next;
        temp.next = temp.next.next;
        next.next = null;
        return head;
    }

    // optimal
    public static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head.next.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node next = slow.next;
        slow.next = slow.next.next;
        next.next = null;
        return head;
    }
}

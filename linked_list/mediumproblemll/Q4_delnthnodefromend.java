package linked_list.mediumproblemll;

import linked_list.Node;

public class Q4_delnthnodefromend {

    // brute
    public Node removeNthFromEndbrute(Node head, int n) {
        if (head == null)
            return head;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == n) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }
        temp = head;
        int res = count - n;
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }
        Node tempp = temp.next;
        temp.next = temp.next.next;
        tempp.next = null;
        return head;
    }

    
    // optimal
    public Node removeNthFromEnd(Node head, int n) {
        if (head == null)
            return head;
        Node fast = head;
        Node slow = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }
}

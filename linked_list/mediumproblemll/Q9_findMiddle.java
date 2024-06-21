package linked_list.mediumproblemll;

import linked_list.Node;

public class Q9_findMiddle {

    public static Node middleNodeBrute(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    // optimal
    public static Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

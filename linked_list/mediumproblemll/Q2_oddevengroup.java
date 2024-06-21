package linked_list.mediumproblemll;

import java.util.ArrayList;

import linked_list.Node;

public class Q2_oddevengroup {
    // brute force
    public static Node oddEvenList(Node head) {
        if (head == null)
            return head;
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null)
            list.add(temp.data);
        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null)
            list.add(temp.data);
        temp = head;
        for (int i = 0; i < list.size(); i++) {
            temp.data = list.get(i);
            temp = temp.next;
        }
        return head;
    }

    // optimized
    public Node oddEvenListOptimized(Node head) {
        if (head == null || head.next == null)
            return head;
        Node evenHead = head.next;
        Node temp1 = head;
        Node temp2 = evenHead;
        while (temp2 != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = evenHead;
        return head;
    }
}

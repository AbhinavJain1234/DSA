package linked_list.learn_doublyll;

import linked_list.NodeD;

public class reversedll {
    public static NodeD reverseDLL(NodeD head) {
        if (head == null || head.next == null) {
            return head;
        }

        NodeD curr = head;
        NodeD prev = null;
        NodeD next = curr.next;

        while (next != null) {
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            next = curr.next;
        }

        curr.next = prev;
        curr.prev = null;

        return curr;
    }

    public static NodeD reverseDLLOptimal(NodeD head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeD temp = null;
        NodeD curr = head;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }

    public static void main(String[] args) {
        NodeD head = new NodeD(10);
        head.next = new NodeD(20);
        head.next.prev = head;
        head.next.next = new NodeD(30);
        head.next.next.prev = head.next;
        head.next.next.next = new NodeD(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new NodeD(50);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new NodeD(60);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new NodeD(70);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new NodeD(80);
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
        head.next.next.next.next.next.next.next.next = new NodeD(90);
        head.next.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next.next;
        head.next.next.next.next.next.next.next.next.next = new NodeD(100);
        head.next.next.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next.next.next;
        NodeD curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
        head = reverseDLLOptimal(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
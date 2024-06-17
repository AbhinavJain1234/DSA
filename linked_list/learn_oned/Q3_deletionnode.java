package linked_list.learn_oned;

import linked_list.Node;

public class Q3_deletionnode {
    public static Node arrayToList(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static Node delete(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deletetaile(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
        return temp;
    }

    public static void printLen(Node head) {
        int n = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Node head = arrayToList(new int[] { 1, 2, 3, 4, 5 });
        printLen(head);
        head = delete(head);
        printLen(head);
        head = deletetaile(head);
        printLen(head);
    }

}

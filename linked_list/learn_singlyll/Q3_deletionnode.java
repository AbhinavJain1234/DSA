package linked_list.learn_singlyll;

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

    public static Node deleteNodeIndex(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            head = head.next;
            return head;
        }
        int counter = 1;
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            counter++;
            if (counter == k) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteNodeVal(Node head, int val) {
        if (head == null) {
            return head;
        }
        if (head.data == val) {
            head = head.next;
            return head;
        }
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void printLen(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = arrayToList(new int[] { 2, 4, 6, 8, 10, 12 });
        printLen(head);
        head = deleteNodeVal(head, 34);
        printLen(head);
    }

}

package linked_list.learn_singlyll;

import linked_list.Node;

public class Q2_insertionll {
    public static Node inserthead(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    public static Node insertTail(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        }
        Node temp1 = head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = temp;
        return head;
    }

    public static Node insertIndex(Node head, int data, int index) {
        Node temp = new Node(data);
        if (index == 1) {
            temp.next = head;
            return temp;
        }
        Node temp1 = head;
        int counter = 2;
        while (temp1.next != null && counter < index) {
            counter++;
            temp1 = temp1.next;
        }
        temp.next = temp1.next;
        temp1.next = temp;
        return head;
    }

    public static Node insertValue(Node head, int data, int value) {
        Node temp = new Node(data);
        if (head.data == value) {
            temp.next = head;
            return temp;
        }
        Node temp1 = head;
        Node prev = null;
        while (temp1.next != null && temp1.data != value) {
            prev = temp1;
            temp1 = temp1.next;
        }
        prev.next = temp;
        temp.next = temp1;
        return head;
    }

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

    public static void printLen(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = arrayToList(new int[] { 1, 2, 3, 4 });
        head = inserthead(head, 5);
        printLen(head);
        head = insertTail(head, 6);
        printLen(head);
        head = insertIndex(head, 7, 8);
        printLen(head);
        head = insertValue(head, 9, 3);
        printLen(head);
    }
}

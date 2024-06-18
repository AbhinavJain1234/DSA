package linked_list.learn_singlyll;

import linked_list.Node;

public class Q1_arraytolinkedlist {

    public static Node arrayToList(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = arrayToList(new int[] { 1, 2, 3, 4, 5 });
        printList(head);
    }
}

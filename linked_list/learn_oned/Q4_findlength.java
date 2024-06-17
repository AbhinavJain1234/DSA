package linked_list.learn_oned;

import linked_list.Node;

public class Q4_findlength {
    public static Node arrayToList(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
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
    }
}

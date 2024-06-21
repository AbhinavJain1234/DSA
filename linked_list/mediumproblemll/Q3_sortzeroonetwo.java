package linked_list.mediumproblemll;

import linked_list.Node;

public class Q3_sortzeroonetwo {
    public static Node segregatebrute(Node head) {
        Node temp = head;
        int count0 = 0, count1 = 0, count2 = 0;
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            } else if (count1 > 0) {
                temp.data = 1;
                count1--;
            } else if (count2 > 0) {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node segregateOptimal(Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
        }
        if (oneHead.next != null) {
            zero.next = oneHead.next;
            one.next = twoHead.next;
            two.next = null;
        } else {
            zero.next = twoHead.next;
            two.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}

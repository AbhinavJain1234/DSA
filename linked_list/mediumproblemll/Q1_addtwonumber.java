package linked_list.mediumproblemll;

import linked_list.Node;

public class Q1_addtwonumber {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node temp1 = l1;
        Node temp2 = l2;
        int carry = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null)
                sum += temp1.data;
            if (temp2 != null)
                sum += temp2.data;
            Node temp = new Node(sum % 10);
            curr.next = temp;
            curr = temp;
            carry = sum / 10;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry != 0) {
            Node temp = new Node(carry);
            curr.next = temp;
        }
        return dummy.next;
    }
}

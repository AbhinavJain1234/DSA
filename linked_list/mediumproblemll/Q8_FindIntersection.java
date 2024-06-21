package linked_list.mediumproblemll;

import java.util.HashSet;

import linked_list.Node;

public class Q8_FindIntersection {
    // brute force but wont work on leetcode
    public static Node intersectionPresent(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // if both nodes are same
                if (temp == head2)
                    return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    // better use hashmap
    public static Node interestionNodeBetter(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head1;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            if (set.contains(temp))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // better 2
    public Node getIntersectionNode(Node head1, Node head2) {
        int diff = getDifference(head1, head2);
        if (diff < 0)
            while (diff++ != 0)
                head2 = head2.next;
        else
            while (diff-- != 0)
                head1 = head1.next;
        while (head1 != null) {
            if (head1 == head2)
                return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }

    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                ++len1;
                head1 = head1.next;
            }
            if (head2 != null) {
                ++len2;
                head2 = head2.next;
            }

        }
        return len1 - len2;// if difference is neg-> length of list2 > length of list1 else vice-versa
    }

    // optimized

    public static Node interestionNodeOptimal(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? head2 : temp1.next;
            temp2 = temp2 == null ? head1 : temp2.next;
        }
        return temp1;
    }
}

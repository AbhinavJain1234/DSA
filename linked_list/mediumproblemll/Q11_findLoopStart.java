package linked_list.mediumproblemll;

import java.util.HashMap;

import linked_list.Node;

public class Q11_findLoopStart {
    public static Node firstNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static Node detectLoopBrute(Node head) {
        Node temp = head;

        HashMap<Node, Integer> nodeMap = new HashMap<>();

        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return temp;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }
}

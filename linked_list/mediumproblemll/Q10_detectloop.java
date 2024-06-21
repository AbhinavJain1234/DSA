package linked_list.mediumproblemll;

import java.util.HashMap;

import linked_list.Node;

public class Q10_detectloop {

    // brute
    public static boolean detectLoopBrute(Node head) {
        Node temp = head;

        HashMap<Node, Integer> nodeMap = new HashMap<>();

        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    // optimized
    public static boolean detectLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}

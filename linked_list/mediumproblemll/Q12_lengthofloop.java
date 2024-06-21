package linked_list.mediumproblemll;

import java.util.HashMap;

import linked_list.Node;

public class Q12_lengthofloop {
    public static int findLengthBrute(Node head) {
        Node temp = head;

        HashMap<Node, Integer> nodeMap = new HashMap<>();
        int timer = 0;
        while (temp != null) {
            timer++;
            if (nodeMap.containsKey(temp)) {
                return timer - nodeMap.get(temp);
            }
            nodeMap.put(temp, timer);
            temp = temp.next;
        }
        return 0;
    }

    public static int findLengthBest(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                while (slow != fast) {
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}

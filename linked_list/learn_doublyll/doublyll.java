package linked_list.learn_doublyll;

import linked_list.NodeD;

public class doublyll {

    public static void insertbeforeNode(NodeD node, int x) {
        NodeD prev = node.prev;
        NodeD temp = new NodeD(x, node, prev);
        prev.next = temp;
        node.prev = temp;
    }

    public static NodeD insertbeforeKthNode(NodeD head, int x, int k) {
        if (k == 1) {
            return insertBeforeHead(head, x);
        }
        if (head == null)
            return head;
        NodeD temp = new NodeD(x);
        NodeD curr = head;
        int counter = 0;
        while (curr != null) {
            counter++;
            if (k == counter)
                break;
            curr = curr.next;
        }
        if (curr == null)
            return head;
        NodeD prev = curr.prev;
        prev.next = temp;
        temp.prev = prev;
        temp.next = curr;
        curr.prev = temp;
        return head;
    }

    public static NodeD insertbeforeTail(NodeD head, int x) {
        NodeD temp = new NodeD(x);
        if (head == null) {
            return temp;
        }
        if (head.next == null)
            return insertBeforeHead(head, x);
        NodeD curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        NodeD prev = curr.prev;
        prev.next = temp;
        temp.prev = prev;
        temp.next = curr;
        curr.prev = temp;
        return head;
    }

    public static NodeD insertAfterTail(NodeD head, int x) {
        if (head == null) {
            return new NodeD(x);
        }
        NodeD curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        NodeD temp = new NodeD(x, null, curr);
        curr.next = temp;
        return head;
    }

    public static NodeD insertBeforeHead(NodeD head, int x) {
        if (head == null)
            return new NodeD(x);
        NodeD temp = new NodeD(x, head, null);
        head.prev = temp;
        return temp;
    }

    public static NodeD insertAfterHead(NodeD head, int x) {
        if (head == null)
            return new NodeD(x);
        NodeD temp = new NodeD(x, head.next, head);
        NodeD temp2 = head.next;
        if (temp2 != null)
            temp2.prev = temp;
        head.next = temp;
        return head;
    }

    public static void delNode(NodeD node) {
        if (node == null || node.next == null) {
            return;
        }
        NodeD prev = node.prev;
        NodeD next = node.next;
        if (next == null) {
            prev.next = null;
            node.prev = null;
        }
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    public static NodeD delIndex(NodeD head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return deleHead(head);
        }
        int counter = 1;
        NodeD temp = head;
        while (temp != null && counter < k) {
            temp = temp.next;
            counter++;
        }
        if (temp == null) {
            return head;
        }
        NodeD prev = temp.prev;
        NodeD next = temp.next;
        if (prev == null && next == null) {
            return null;
        }
        if (prev == null) {
            return deleHead(head);
        }
        if (next == null) {
            return deleTail(head);
        }
        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static NodeD deleTail(NodeD head) {
        if (head == null || head.next == null) {
            return null;
        }
        NodeD temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        NodeD prev = temp;
        temp = temp.next;
        prev.next = null;
        temp.prev = null;
        return head;
    }

    public static NodeD deleHead(NodeD head) {
        if (head == null || head.next == null) {
            return null;
        }
        NodeD prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    public static NodeD arraytoDD(int arr[]) {
        NodeD head = new NodeD(arr[0]);
        NodeD prev = head;
        for (int i = 1; i < arr.length; i++) {
            NodeD temp = new NodeD(arr[i]);
            temp.prev = prev;
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printLen(NodeD head) {
        NodeD temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        NodeD head = arraytoDD(arr);
        printLen(head);
        // head = deleHead(head);
        // printLen(head);
        // head = deleTail(head);
        // printLen(head);
        head = delIndex(head, 3);
        head = insertBeforeHead(head, 10);
        printLen(head);
    }
}

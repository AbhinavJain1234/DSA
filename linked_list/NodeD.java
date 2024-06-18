package linked_list;

public class NodeD {
    public int data;
    public NodeD next;
    public NodeD prev;

    public NodeD(int data) {
        this.data = data;
        this.next = null;
        prev = null;
    }

    public NodeD(int data, NodeD next, NodeD prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

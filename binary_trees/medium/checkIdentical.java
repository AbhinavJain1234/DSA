package binary_trees.medium;



import binary_trees.Node;

public class checkIdentical {
    public boolean isSameTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return ((node1.data == node2.data)
                && isSameTree(node1.left, node2.left)
                && isSameTree(node1.right, node2.right));
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        checkIdentical c = new checkIdentical();
        System.out.println(c.isSameTree(root1, root2));
    }
}

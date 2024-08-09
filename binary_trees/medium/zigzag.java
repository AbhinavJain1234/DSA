package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

public class zigzag {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean leftToRight = true;
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = nodesQueue.poll();
                row.add(node.data);
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }
            if(!leftToRight)Collections.reverse(row);
            leftToRight = !leftToRight;
            result.add(row);
        }
        return result;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        zigzag z=new zigzag();
        List<List<Integer>> ans = z.zigzagLevelOrder(root);
        for (List<Integer> level : ans) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

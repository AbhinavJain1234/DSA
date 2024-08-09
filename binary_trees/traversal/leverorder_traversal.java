package binary_trees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import binary_trees.Node;

public class leverorder_traversal {
    public static List<List<Integer>> levelorder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {

            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.data);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        List<List<Integer>> ans = levelorder(root);
        for (List<Integer> level : ans) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

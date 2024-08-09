package binary_trees.medium;

import java.util.LinkedList;
import java.util.Queue;

import binary_trees.Node;

public class depth {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        depth obj = new depth();
        System.out.println(obj.maxDepth(root));
        System.out.println(obj.maxDepthLevel(root));
    }


    public int maxDepthLevel(Node root) {
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Node temp = q.poll();
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}

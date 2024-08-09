package binary_trees.medium;

import binary_trees.Node;

public class checkbalanced {
    public static boolean check(Node root){
        if(root==null)return true;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if(Math.abs(lh-rh)>1)return false;
        boolean left = check(root.left);
        boolean right = check(root.right);
        return left && right;

    }
    public static int maxDepth(Node root) {
        if(root==null)return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static boolean isBalanced(Node root) {
        return height(root)!=-1;
    }

    public static int height(Node root){
        if(root==null)return 0;
        int lh = height(root.left);
        if(lh==-1)return -1;
        int rh = height(root.right);
        if(rh==-1)return -1;
        if(Math.abs(lh-rh)>1)return -1;
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        System.out.println(check(root));
        System.out.println(isBalanced(root));
    }
}

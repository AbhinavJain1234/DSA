package binary_trees.hard;

import binary_trees.Node;

public class lca {
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if (root == null )return null;
        if(root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { 
            return root;
        }
    }
}

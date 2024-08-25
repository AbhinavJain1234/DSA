package binary_search_tree.practice;

import binary_search_tree.TreeNode;

public class checkifbst {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long min, long max){
        if(node==null)return true;
        if(node.data<=min || node.data>=max)return false;
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }
}

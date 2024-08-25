package binary_search_tree.introduction;

import binary_search_tree.TreeNode;

public class findminmax {
    public static TreeNode fun(TreeNode root){
        while(root.left!=null)root=root.left;
        return root;
    }
    public static TreeNode fun2(TreeNode root){
        while(root.right!=null)root=root.right;
        return root;
    }
}

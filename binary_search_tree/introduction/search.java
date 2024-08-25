package binary_search_tree.introduction;

import binary_search_tree.TreeNode;

public class search{
    public static TreeNode ssearch(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (root.data < key) {
            return ssearch(root.right, key);
        }
        return ssearch(root.left, key);
    }
    public static TreeNode sssearch(TreeNode root,int key){
        while(root!=null&&root.data!=key){
            if(root.data<key){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return root;
    }
}
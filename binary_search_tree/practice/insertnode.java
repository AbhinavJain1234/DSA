package binary_search_tree.practice;

import binary_search_tree.TreeNode;

public class insertnode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        TreeNode curr=root;
        while(true){
            if(root.data<val){
                if(root.right==null){
                    TreeNode right=new TreeNode(val);
                    root.right=right;
                    break;
                }
                else{
                    root=root.right;
                }
            }else{
               if(root.left==null){
                    TreeNode left=new TreeNode(val);
                    root.right=left;
                    break;
                }
                else{
                    root=root.left;
                } 
            }
        }
        return curr;
    }
}

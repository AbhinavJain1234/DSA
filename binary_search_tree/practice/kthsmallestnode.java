package binary_search_tree.practice;

import binary_search_tree.TreeNode;

public class kthsmallestnode {
    public static int fun(TreeNode root, int k){
        int[] ans=new int[2];
        inorder(root,k,ans);
        return ans[1];
    }
    public static void inorder(TreeNode node, int k, int[] ans){
        if(node==null)return;
        inorder(node.left,k,ans);
        ans[0]++;
        if(ans[0]==k){
            ans[1]=node.data;
            return;
        }
        inorder(node.right,k,ans);
    }
}

package binary_search_tree.practice;

import binary_search_tree.TreeNode;

public class lcabst {
     public static int fun(TreeNode root,int p,int q){
        if(root==null)return -1;
        if(root.data>p && root.data>q)return fun(root.left,p,q);
        if(root.data<p && root.data<q)return fun(root.right,p,q);
        return root.data;
     }
     public static int lowestCa(TreeNode root,int p,int q){
        while(root!=null){
            if(root.data>p && root.data>q)root=root.left;
            else if(root.data<p && root.data<q)root=root.right;
            else return root.data;
        }
        return -1;
     }
     public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(fun(root,1,3));
        System.out.println(lowestCa(root,1,3));
     }
}

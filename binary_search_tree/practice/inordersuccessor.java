package binary_search_tree.practice;

import java.util.*;

import binary_search_tree.TreeNode;

public class inordersuccessor {
    public static int[] helper(TreeNode root){
        if(root==null)return new int[0];
        int left[]=helper(root.left);
        int right[]=helper(root.right);
        int res[]=new int[left.length+right.length+1];
        int i=0;
        for(;i<left.length;i++){
            res[i]=left[i];
        }
        res[i++]=root.data;
        for(int j=0;j<right.length;j++){
            res[i++]=right[j];
        }
        return res;
    }
    public static void inOrderSuccessorBrute(TreeNode root,int p){
        int inorder[]=helper(root);
        for(int i=0;i<inorder.length;i++){//use binary search
            if(inorder[i]==p){
                System.out.println(inorder[i+1]);
                break;
            }
        }
    }

    public List<Integer> succPredBSTBetter(TreeNode root, int key) {
        List<Integer> result = new ArrayList<>();
        TreeNode succ = null;
        TreeNode pred = null;
        while (root != null) {
            if (root.data == key) {
                if (root.right != null) {
                    succ = findMin(root.right);
                }
                if (root.left != null) {
                    pred = findMax(root.left);
                }
                break;
            } else if (root.data < key) {
                pred = root;
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        if (pred != null) {
            result.add(pred.data);
        } else {
            result.add(-1); 
        }

        if (succ != null) {
            result.add(succ.data);
        } else {
            result.add(-1); 
        }
        return result;
    }
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(12);
        inOrderSuccessorBrute(root,5);
    }
}


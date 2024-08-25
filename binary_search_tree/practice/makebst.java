package binary_search_tree.practice;
import java.util.*;

import binary_search_tree.TreeNode;

public class makebst {
    public static TreeNode brute(List<Integer> preorder) {
        if (preorder.isEmpty()) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.size(); i++) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder.get(i));
            while (!stack.isEmpty() && stack.peek().data < preorder.get(i)) {
                node = stack.pop();
            }
            if (node.data < preorder.get(i)) {
                node.right = child;
            } else {
                node.left = child;
            }
            stack.push(child);
        }

        return root;
    }
    public static TreeNode better(List<Integer> preorder) {
        Collections.sort(preorder);
        return helperBrute(preorder,0,preorder.size()-1,null);
        // now can use both preorder and inorder to create a binary tree
        //here we will see how to createonly inorder

    }
    public static TreeNode helperBrute(List<Integer> inorder,int start,int end,TreeNode root){
        if(start>end)return null;
        int mid = (start+end)/2;
        root = new TreeNode(inorder.get(mid));
        helperBrute(inorder,start,mid-1,root.left);
        helperBrute(inorder,mid+1,end,root.right);
        return root;
    }


    public static TreeNode optimal(List<Integer> preorder){
        return helperOptimal(preorder,Integer.MAX_VALUE, new int[]{0});
    }
    public static TreeNode helperOptimal(List<Integer> preorder,int ub,int index[]){
        if (index[0] == preorder.size() || preorder.get(index[0]) > ub) return null;
        TreeNode root = new TreeNode(preorder.get(index[0]) );
        index[0]++;
        root.left = helperOptimal(preorder, root.data, index);
        root.right = helperOptimal(preorder, ub, index);
        return root;
    }
    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>(Arrays.asList(8,5,1,7,10,12));
        TreeNode root = brute(preorder);
        System.out.println(root.data);
        root = optimal(preorder);
        System.out.println(root.data);
        root = better(preorder);
        System.out.println(root.data);
    }
}



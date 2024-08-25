package binary_search_tree.practice;

import binary_search_tree.TreeNode;

class deleteNode {
   public static TreeNode helper(TreeNode root) {
       if (root.left == null) return root.right;
       if (root.right == null) return root.left;
       TreeNode leftChild = root.left;
       TreeNode leftmostChildInRightSubtree = root.right;
       while (leftmostChildInRightSubtree.left != null) {
           leftmostChildInRightSubtree = leftmostChildInRightSubtree.left;
       }
       leftmostChildInRightSubtree.left = leftChild;
       return root.right;
   }
   public static TreeNode deleteNodee(TreeNode root, int key) {
       if (root == null) return null;
       if (root.data == key) {
           return helper(root);
       }
       TreeNode node = root;
       while (node != null) {
           if (node.data > key) {
               if (node.left != null && node.left.data == key) {
                   node.left = helper(node.left);
                   break;
               } else {
                   node = node.left; 
               }
           }
           else {
               if (node.right != null && node.right.data == key) {
                   node.right = helper(node.right);
                   break;
               } else {
                   node = node.right; 
               }
           }
       }
       return root;
   }

   public static void main(String[] args) {
       TreeNode root = new TreeNode(5);
       root.left = new TreeNode(3);
       root.right = new TreeNode(8);
       root.left.left = new TreeNode(2);
       root.left.right = new TreeNode(4);
       root = deleteNodee(root, 3);
   }
}

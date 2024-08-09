package binary_trees.medium;

import binary_trees.Node;

public class maxsumpath {
    public static int maxPathSum(Node root) {
        int[] ans=new int[1];
        ans[0] = Integer.MIN_VALUE; 
        fun(root,ans);
        return ans[0];
    }
    public static int fun(Node root,int[] max){
        if(root==null)return 0;
        int lh=Math.max(0,fun(root.left,max));
        int rh=Math.max(0,fun(root.right,max));
        max[0]=Math.max(max[0],lh+rh+root.data);
        return root.data+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(2);
        root.right=new Node(10);
        root.left.left=new Node(20);
        root.left.right=new Node(1);
        root.right.right=new Node(-25);
        root.right.right.left=new Node(3);
        root.right.right.right=new Node(4);
        System.out.println(maxPathSum(root));
    }
}

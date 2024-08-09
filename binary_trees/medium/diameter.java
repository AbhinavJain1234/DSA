package binary_trees.medium;

import binary_trees.Node;

public class diameter {
    public int fun(Node root,int[] max){
        if(root==null)return 0;
        int lh=fun(root.left,max);
        int rh=fun(root.right,max);
        max[0]=Math.max(max[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterr(Node root) {
        int[] max=new int[1];
        max[0]=0;
        fun(root,max);
        return max[0];
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        diameter d=new diameter();
        System.out.println(d.diameterr(root));
    }
}

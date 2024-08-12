package binary_trees.hard;

import binary_trees.Node;

public class countNodesincomplete {
    public int countNodes(Node root) {
        if(root==null)return 0;
        int lh=0;
        Node node=root;
        while(node!=null){
            lh++;
            node=node.left;
        }
        int rh=0;
        node=root;
        while(node!=null){
            rh++;
            node=node.right;
        }
        if(lh==rh)return ((int)Math.pow(2,lh)-1);
        else return 1+countNodes(root.left)+countNodes(root.right);

    }
}

package binary_trees.hard;

import java.util.*;

import binary_trees.Node;

public class treefrrominpre {
    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        Node root=build(preorder,0,preorder.length-1, 0, n-1, map);
        return root;
    }
    private static Node build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);
        int inIndex = map.get(rootVal);
        int leftSize = inIndex - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, inIndex - 1, map);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inIndex + 1, inEnd, map);
        return root;
    }
    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        Node root=buildTree(preorder, inorder);
        System.out.println(root.data);
    }
}

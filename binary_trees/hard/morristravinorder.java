package binary_trees.hard;

import java.util.ArrayList;
import java.util.List;


import binary_trees.Node;

public class morristravinorder{
    public static List<Integer> inorder(Node root){
        List<Integer> inorder = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.data);//put it in null check for preorder
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}
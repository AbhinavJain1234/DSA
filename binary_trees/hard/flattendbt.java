package binary_trees.hard;

import java.util.Stack;

import binary_trees.Node;

public class flattendbt {
    public static void optimal(Node root){
         Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node prev = cur.left;
                while (prev.right != null ) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right=cur.left;
                cur.left=null;
                
            }
            cur=cur.right;
        }
    }
    public Node prev = null;
    public  void flatten(Node root){
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    
    }

    public static void betterInteratively(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            Node cur = st.pop();
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                st.push(cur.left);
            }
            if (!st.empty()) {
                cur.right = st.peek();
            }
            cur.left = null;
        }

    }
}

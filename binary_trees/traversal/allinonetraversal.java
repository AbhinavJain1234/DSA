package binary_trees.traversal;

                            
import java.util.*;

import binary_trees.Node;

class Pair{
    Node key;
    int value;
    Pair(Node key){
        this.key = key;
        this.value = 1;
    }
    Pair(Node key, int value){
        this.key = key;
        this.value = value;
    }
    public Node getKey(){
        return this.key;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
}
public class allinonetraversal {
    public static List<List<Integer>> preInPostTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));

        while (!st.empty()) {
            Pair it = st.pop();
            if (it.getValue() == 1) {
                pre.add(it.getKey().data);
                it.setValue(2);
                st.push(it);
                if (it.getKey().left != null) {
                    st.push(new Pair(it.getKey().left, 1));
                }
            }
            else if (it.getValue() == 2) {
                in.add(it.getKey().data);
                it.setValue(3);
                st.push(it);
                if (it.getKey().right != null) {
                    st.push(new Pair(it.getKey().right, 1));
                }
            }
            else {
                post.add(it.getKey().data);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> pre, in, post;
        List<List<Integer>> traversals = preInPostTraversal(root);
        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
                            
                        
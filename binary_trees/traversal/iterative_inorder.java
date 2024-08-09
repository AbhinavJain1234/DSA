package binary_trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import binary_trees.Node;

public class iterative_inorder {
    public static List<Node> inorder(Node root){
        List<Node> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(true){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                curr=stack.pop();
                ans.add(curr);
                curr=curr.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        List<Node> ans = inorder(root);
        for (Node node : ans) {
            System.out.print(node.data + " ");
        }
    }
    
}

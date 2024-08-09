package binary_trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import binary_trees.Node;

public class iterative_postorder {
    public static List<Integer> postorder2stack(Node node){
        List<Integer> ans=new ArrayList<>();
        if(node==null)return ans;
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            Node curr=stack1.pop();
            stack2.push(curr);
            if(curr.left!=null){
                stack1.push(curr.left);
            }
            if(curr.right!=null){
                stack1.push(curr.right);
            }
        }
        while(!stack2.isEmpty()){
            ans.add(stack2.pop().data);
        }
        return ans;
    }

    public static List<Integer> postorder1stack(Node node){
        Node curr=node;
        Stack<Node> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while(curr != null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                Node temp=stack.peek().right;
                if(temp==null){
                    temp=stack.peek();
                    ans.add(temp.data);
                    stack.pop();
                    while (!stack.isEmpty()&&temp==stack.peek().right) {
                        temp=stack.peek();
                        stack.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    curr=temp;
                }
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
        List<Integer> ans = postorder2stack(root);
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
        ans = postorder1stack(root);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}

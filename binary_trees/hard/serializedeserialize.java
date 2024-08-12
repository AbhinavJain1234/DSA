package binary_trees.hard;

import java.util.LinkedList;
import java.util.Queue;

import binary_trees.Node;


public class serializedeserialize {
    public String serialize(Node root) {
        String ans = "";
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if(node==null){
                    ans+="# ";
                    continue;
                }
                ans=ans+node.data+" ";
                q.add(node.left);
                q.add(node.right);
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String s) {
        if(s=="")return null;
        String[] values=s.split(" ");
        Node root=new Node(Integer.parseInt(values[0]));
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        for(int i=1;i<values.length;i++){
            Node node=queue.poll();
            if(!values[i].equals("#")){
                Node left=new Node(Integer.parseInt(values[i]));
                node.left=left;
                queue.offer(left);
            }
            if(!values[++i].equals("#")){
                Node right=new Node(Integer.parseInt(values[i]));
                node.right=right;
                queue.offer(right);
            }
        }
        return root;
    }
}

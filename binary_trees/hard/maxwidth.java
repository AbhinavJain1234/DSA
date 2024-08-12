package binary_trees.hard;

import java.util.LinkedList;
import java.util.Queue;

import binary_trees.Node;



public class maxwidth {
    class Pair {
    int num; // index of the node
    Node node;
    
    Pair(int num, Node node) {
        this.num = num;
        this.node = node;
    }
}
    public int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, root)); // start with index 1
        
        while(!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num; // minimum index at current level
            int first = 0, last = 0;
            
            for(int i = 0; i < size; i++) {
                int curr_index = q.peek().num - mmin; // normalized index
                Node node = q.peek().node;
                q.poll();
                
                if(i == 0) first = curr_index;
                if(i == size - 1) last = curr_index;
                
                if(node.left != null) q.offer(new Pair(curr_index * 2, node.left));
                if(node.right != null) q.offer(new Pair(curr_index * 2 + 1, node.right));
            }
            ans = Math.max(ans, last - first + 1);
        }
        
        return ans;
    }
}

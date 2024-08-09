package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

class Pair2{
    int number;
    Node node;
    public Pair2(Node node,int val){
        this.node=node;
        this.number=val;
    }
}
public class top_view {
    public List<Integer> topView(Node root) {
        //your code goes here
        List<Integer> result =new ArrayList<>();
        Queue<Pair2> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair2(root,0));
        map.put(0,root.data);
        while(!q.isEmpty()){
            Pair2 item=q.poll();
            Node node =item.node;
            int line=item.number;
            if(!map.containsKey(line)){
                map.put(line,node.data);
            }
            if (node.left != null) {
                q.add(new Pair2(node.left, line - 1));
            }
            
            if (node.right != null) {
                q.add(new Pair2(node.right, line + 1));
            }
        }
        for(int val : map.values()) result.add(val);
        return result;
    }   
}

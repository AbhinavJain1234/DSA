package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

class Pair1{
    int number;
    Node node;
    public Pair1(Node node,int val){
        this.node=node;
        this.number=val;
    }
}
public class bottomview {
    public List<Integer> bottomView(Node root) {
        List<Integer> result =new ArrayList<>();
        Queue<Pair1> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair1(root,0));
        map.put(0,root.data);
        while(!q.isEmpty()){
            Pair1 item=q.poll();
            Node node =item.node;
            int line=item.number;
            if(map.containsKey(line)){
                map.remove(line);
            }
            map.put(line,node.data);
            if (node.left != null) {
                q.add(new Pair1(node.left, line - 1));
            }
            
            if (node.right != null) {
                q.add(new Pair1(node.right, line + 1));
            }
        }
        for(int val : map.values()) result.add(val);
        return result;
    }
}

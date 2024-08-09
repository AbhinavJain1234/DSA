package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

class Pairr{
    int number;
    Node node;
    public Pairr(Node node,int val){
        this.node=node;
        this.number=val;
    }
 }
class rightview {
    public List<Integer> rightSideView(Node root) {
        //your code goes here)
         List<Integer> result =new ArrayList<>();
         if(root==null)return result;
        Queue<Pairr> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pairr(root,0));
        map.put(0,root.data);
        while(!q.isEmpty()){
            Pairr item=q.poll();
            Node node =item.node;
            int line=item.number;
            if(map.containsKey(line)){
                map.remove(line);
            }
            map.put(line,node.data);
            if (node.left != null) {
                q.add(new Pairr(node.left, line+1));
            }
            
            if (node.right != null) {
                q.add(new Pairr(node.right, line + 1));
            }
        }
        for(int val : map.values()) result.add(val);
        return result;
    }
}
package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

public class pathtonode {
    public List<List<Integer>> allRootToLeaf(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        traversal(root,new ArrayList<>(),ans);
        return ans;
    }
    public static void traversal(Node node,List<Integer> list,List<List<Integer>> ans){
        if(node==null)return;
        list.add(node.data);
        if(node.left==null&&node.right==null){
            ans.add(new ArrayList<>(list));
        }else{
        traversal(node.left,list,ans);
        traversal(node.right,list,ans);
        }
        list.remove(list.size() - 1);
    }
}

package binary_search_tree.practice;

import java.util.*;

import binary_search_tree.TreeNode;

public class findcielfloor {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> list=new ArrayList<>();
        list.add(fun1(root,key));
        list.add(fun2(root,key));
        return list;
    }
    public static int fun1(TreeNode node, int val){
        int ans=-1;
        while(node!=null){
            if(node.data==val)return val;
            if(node.data>val){
                node=node.left;
            }
            else {
                ans=node.data;
                node=node.right;
            }
        }
        return ans;
    }

    public static int fun2(TreeNode node, int val){
        int ans=-1;
        while(node!=null){
            if(node.data==val)return val;
            if(node.data<val){
                node=node.right;
            }
            else {
                ans=node.data;
                node=node.left;
            }
        }
        return ans;
    }

}

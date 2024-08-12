package binary_trees.hard;

import java.util.HashMap;
import java.util.Map;

import binary_trees.Node;


public class treefrominpost {
    public Node buildTree(int[] inorder, int[] postorder) {
        if ( postorder.length != inorder.length) {
            return null;
        }
        
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(postorder, 0, postorder.length - 1, 0, inorder.length - 1, inorderMap);
    }

    private Node buildTreeHelper(int[] postorder, int ps, int pe,  int is, int ie, 
                                     Map<Integer, Integer> inorderMap) {
        if (ps > pe || is > ie) {
            return null;
        }

        
        Node root = new Node(postorder[pe]);
        int rootIndexInorder = inorderMap.get(postorder[pe]);
        int leftSubtreeSize = rootIndexInorder - is;

        root.left = buildTreeHelper(postorder, ps, ps + leftSubtreeSize - 1, is, rootIndexInorder - 1, inorderMap);
        
        root.right = buildTreeHelper(postorder, ps + leftSubtreeSize, pe - 1, rootIndexInorder + 1, ie, inorderMap);

        return root;
    }
}

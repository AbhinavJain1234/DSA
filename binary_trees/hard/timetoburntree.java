package binary_trees.hard;

import java.util.*;

import binary_trees.Node;

class timetoburntree {
    public static int minTime(Node root, int target) 
    {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = findTargetAndMapParents(root, target, parentMap);

        if (targetNode == null) return 0;  // Target not found

        int time = 0;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(targetNode);
        visited.add(targetNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                if (node.left != null && visited.add(node.left)) {
                    queue.add(node.left);
                    burned = true;
                }
                
                if (node.right != null && visited.add(node.right)) {
                    queue.add(node.right);
                    burned = true;
                }
                
                if (parentMap.containsKey(node) && visited.add(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    burned = true;
                }
            }
            
            if (burned) {
                time++;
            }
        }

        return time;
    }

    private static Node findTargetAndMapParents(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.data == target) {
                targetNode = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        return targetNode;
    }
}

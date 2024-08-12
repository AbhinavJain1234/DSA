package binary_trees.hard;

import java.util.*;

import binary_trees.Node;

public class allNodesAtKDistanceFromSpecificNode {
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        List<Integer> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;
        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().data);
                }
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDistance++;
        }

        return result;
    }
}

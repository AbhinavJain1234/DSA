package binary_trees.medium;

import java.util.*;

import binary_trees.Node;

class Pair {
    int col, row;
    Node node;
    Pair(int col, int row, Node node) {
        this.col = col;
        this.row = row;
        this.node = node;
    }
}
public class verticalordertraversal {
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, root));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int col = pair.col, row = pair.row;
            Node node = pair.node;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).offer(node.data);

            if (node.left != null) {
                queue.offer(new Pair(col - 1, row + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair(col + 1, row + 1, node.right));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                while (!nodes.isEmpty()) {
                    vertical.add(nodes.poll());
                }
            }
            result.add(vertical);
        }

        return result;
    }
}
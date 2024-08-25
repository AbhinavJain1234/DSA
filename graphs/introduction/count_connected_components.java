package graphs.introduction;

import java.util.*;

public class count_connected_components {

    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        int[] visited = new int[V];
        int flag = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                flag++;
                traversal(i, visited, adjList);
            }
        }
        return flag;
    }
    private void traversal(int node, int[] visited, List<List<Integer>> adjList) {
        visited[node] = 1;
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor] == 0) {
                traversal(neighbor, visited, adjList);
            }
        }
    }
}

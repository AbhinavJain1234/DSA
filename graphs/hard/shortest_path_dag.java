package graphs.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class shortest_path_dag {

    private void topoSort(int node, List<int[]>[] adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;  // Mark the current node as visited
        for (int[] edge : adj[node]) {
            int v = edge[0];  // Get the vertex connected to the current node
            if (!vis[v]) {
                topoSort(v, adj, vis, st);  // Recursively visit the unvisited vertex
            }
        }
        st.push(node);  // Push the current node to the stack after visiting all neighbors
    }

    // Function to find the shortest path in a DAG
    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create adjacency list
        @SuppressWarnings("unchecked")
        List<int[]>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj[u].add(new int[]{v, wt});  // Add edge to adjacency list
        }

        boolean[] vis = new boolean[N];  // Visited array for performing topological sort
        Stack<Integer> st = new Stack<>();  // Stack to store the topological order
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);  // Perform topological sort
            }
        }

        int[] dist = new int[N];  // Array to store the shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);  // Initialize distances with infinity
        dist[0] = 0;  // Distance to source is 0

        // Process vertices in topological order
        while (!st.isEmpty()) {
            int node = st.pop();  // Get the vertex from the stack
            for (int[] edge : adj[node]) {
                int v = edge[0];  // Adjacent vertex
                int wt = edge[1];  // Weight of the edge
                // Check if we can improve the distance to the vertex v
                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;  // Update distance
                }
            }
        }

        // Replace unreachable distances with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;  // Return the shortest distances
    }
}
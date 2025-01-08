package graphs.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortest_path_undirected {
    public int[] shortestPath(int[][] edges, int N, int M) {
        // Initialize adjacency list
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v); 
            adj[v].add(u);
        }

        // Distance array initialized to infinity
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int val : adj[node]) {
                if (distance[val] > distance[node] + 1) {
                    distance[val] = distance[node] + 1;
                    queue.offer(val);  // Enqueue only if the distance is updated
                }
            }
        }

        // Replace any remaining 'infinity' distances with -1 to indicate unreachable nodes
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}

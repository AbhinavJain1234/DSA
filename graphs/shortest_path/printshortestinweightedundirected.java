package graphs.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class printshortestinweightedundirected {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{0, 1});
        dist[1] = 0;
        int[] parent=new int[n+1];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int dis = curr[0];
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0]; 
                int edWt = neighbor[1]; 
                if (dis + edWt < dist[adjNode]) {
                    dist[adjNode] = dis + edWt;
                    pq.add(new int[]{dis + edWt, adjNode});
                    parent[adjNode] = node;
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node); 
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);
        return path;
    }
}

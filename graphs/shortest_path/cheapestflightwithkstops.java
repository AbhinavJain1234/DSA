package graphs.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cheapestflightwithkstops {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int k) {
      
      List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src]=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int stops = p[0]; 
            int node = p[1]; 
            int dist = p[2]; 
            if (stops > k) continue;
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0]; 
                int edgeWt = neighbor[1];
                if (dist + edgeWt < minDist[adjNode] && 
                    stops <= k) {
                        minDist[adjNode] = dist + edgeWt;
                        q.offer(new int[]{stops + 1, adjNode, dist + edgeWt});
                }
            }
        }
        if (minDist[dst] == Integer.MAX_VALUE) 
            return -1;
        return minDist[dst];
    }
}

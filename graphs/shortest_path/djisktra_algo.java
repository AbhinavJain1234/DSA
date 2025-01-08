package graphs.shortest_path;

import java.util.*;

public class djisktra_algo {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<DjPair> pq = new PriorityQueue<DjPair>((a, b) -> a.dist - b.dist);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.add(new DjPair(S, 0));

        while (!pq.isEmpty()) {
            DjPair curr = pq.poll();
            int dis = curr.dist;
            int node = curr.node;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new DjPair(adjNode, dist[adjNode]));
                }
            }
        }
         for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = 1000000000;
            }
        }
        return dist;
    }
    public int[] dijkstraset(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<DjPair> st = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist) {
                return Integer.compare(a.node, b.node); 
            }
            return Integer.compare(a.dist, b.dist);
        });

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        st.add(new DjPair(S,0));

        while (!st.isEmpty()) {
            DjPair top = st.pollFirst();
            int dis = top.dist;
            int node = top.node;
            for (ArrayList<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);
                if (dis + edgeWt < dist[adjNode]) {
                    DjPair toRemove = new DjPair( adjNode,dist[adjNode]);
                    st.remove(toRemove); 
                    dist[adjNode] = dis + edgeWt;
                    st.add(new DjPair( adjNode,dist[adjNode]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = 1000000000;
            }
        }

        return dist;
    }

}
class DjPair {
    int node;
    int dist;

    public DjPair(int node, int dist) {  
        this.node = node;
        this.dist = dist;  
    }

    
}

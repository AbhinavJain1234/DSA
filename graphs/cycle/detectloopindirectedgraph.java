package graphs.cycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class detectloopindirectedgraph {
    public boolean isCyclicDFS(int V, List<Integer>[] adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, List<Integer>[] adj, int[] visited, int[] pathVisited) {
        visited[i] = 1;
        pathVisited[i] = 1;
        for (int it : adj[i]) {
            if(pathVisited[it]==1) 
                return true;
            else if(visited[it]==0) {
                if(dfs(it, adj, visited, pathVisited)) 
                    return true;
            }
        }
        pathVisited[i] = 0;
        return false;
    }
    public boolean isCyclicBFS(int V, List<Integer>[] adj) {
        int inDegree[] = new int[V];
        int count=0;
        
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) inDegree[it]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) queue.offer(it);
            }
        }
        return count!=V;
    }
}

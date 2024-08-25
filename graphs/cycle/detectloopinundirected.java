package graphs.cycle;

import java.util.*;

public class detectloopinundirected {
    public boolean isCycleBFS(int V, List<Integer>[] adj) {
        int visited[] = new int[V];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {  // Handle all components of the graph
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(new int[]{i, -1});
                
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int node = curr[0];
                    int parent = curr[1];
                    
                    for (int val : adj[node]) {
                        if (visited[val] == 0) {
                            visited[val] = 1;
                            queue.offer(new int[]{val, node});
                        } else if (val != parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isCycleDFS(int V, List<Integer>[] adj) {
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {  // Handle all components of the graph
            if (visited[i] == 0) {
                if(dfs(i,-1,adj,visited))return true;
            }
        }
        return false;
    }
    private boolean dfs(int i,int parent,List<Integer>[] adj,int[] visited){
        visited[i]=1;
        for (int val : adj[i]) {
            if(visited[val]==0){
                if(dfs(val,i,adj,visited))return true;
            }
            else if(val!=parent)return true;
        }
        return false;
    }
}

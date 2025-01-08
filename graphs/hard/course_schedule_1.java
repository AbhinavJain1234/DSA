package graphs.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//can also be done by dfs
public class course_schedule_1 {
    public boolean canFinish(int V, int[][] arr) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            adj[arr[i][1]].add(arr[i][0]);
        }   
        return !isCyclicBFS(V,adj);
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

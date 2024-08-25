package graphs.cycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class topologicalsort {
    //Kahns Algorithm
    public int[] topoSortBFS(int V, List<Integer>[] adj) {
        int inDegree[] = new int[V];
        int[] ans = new int[V];
        int index = 0;
        
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) inDegree[it]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[index++] = node;
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) queue.offer(it);
            }
        }
        
        return ans;
    }
    
    public int[] topoSortDFS(int V, List<Integer>[] adj) {
        int[] visited=new int[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,stack,visited);
            }
        }
        int ans[]=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=stack.pop();
        }
        return ans;
    }
    void dfs(int node,List<Integer>[] adj,Stack<Integer> stack,int[] visited){
        visited[node]= 1;
        for(int it : adj[node]) {
            if(visited[it] == 0) dfs(it, adj, stack,visited );
        }
        stack.push(node);
    }
}

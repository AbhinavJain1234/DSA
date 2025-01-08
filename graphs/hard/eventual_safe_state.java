package graphs.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class eventual_safe_state {
    @SuppressWarnings("unchecked")
    public int[] eventualSafeNodesbfs(int V, int[][] graph) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<V;i++){
            for(int j:graph[i]){
                adj[j].add(i);
            }
        }
        int inDegree[]=new int[V];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            inDegree[i]=graph[i].length;
            if(inDegree[i]==0)queue.add(i);
        }
        List<Integer> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans.add(node);
            for(int val:adj[node]){
                inDegree[val]--;
                if(inDegree[val]==0)queue.add(val);
            }
        }
        Collections.sort(ans);
        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }

        return array;

    }
    public int[] eventualSafeNodesDFS(int v, int[][] graph) {
        int[] visited = new int[v];
        int pathVisited[] = new int[v];
        int checkedNode[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, pathVisited, checkedNode);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < v; i++) {
            if (checkedNode[i] == 1) ans.add(i);
        }
        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }

        return array;
    }
    boolean dfs(int node, int[][] graph, int[] visited, int pathVisited[], int[] checkedNode) {
        visited[node] = 1;
        pathVisited[node] = 1;
        checkedNode[node] = 0;
        for (int it : graph[node]) {
            if (pathVisited[it] == 1) {
                return true;
            } else if (visited[it] == 0) {
                if (dfs(it, graph, visited, pathVisited, checkedNode)) {
                    return true;
                }
            }
        }
        pathVisited[node] = 0;
        checkedNode[node] = 1;
        return false;
    }
}

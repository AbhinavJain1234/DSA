package graphs.cycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bipartite {
    public boolean isBipartiteBFD(int V, List<Integer>[] adj) {
        int color[]=new int[V];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(color[i]==0){
                queue.offer(i);
                color[i]=1;
                while(!queue.isEmpty()){
                    int node=queue.poll();
                    for(int val:adj[node]){
                        if(color[val]==0){
                            color[val]=-color[node];
                            queue.offer(val);
                        } else if(color[val]==color[node]){
                                return false;
                            }
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartiteDFS(int V, List<Integer>[] adj) {
        int color[]=new int[V];
        for(int i=0;i<V;i++){
            if(color[i]==0){
                color[i]=1;
                if(!dfs(i,adj,color))return false;
            }
        }
        return true;
    }
    boolean dfs(int i,List<Integer>[] adj,int[] color){
        for(int val:adj[i]){
            if(color[val]==0){
                color[val]=-color[i];
                if(!dfs(val,adj,color))return false;
            } else if(color[val]==color[i])return false;
        }
        return true;
    }
}

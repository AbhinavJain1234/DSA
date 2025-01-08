package graphs.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class alien_dictionary {
    public String findOrder(String [] dict, int N, int K) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adj=new ArrayList[K];
            for (int i = 0; i < K; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i=0;i<N-1;i++){
                String s1=dict[i];
                String s2=dict[i+1];
                int p=0;int q=0;
                while(p<s1.length()&&q<s2.length()){
                    if(s1.charAt(p)!=s2.charAt(q)){
                        adj[s1.charAt(p)-'a'].add(s2.charAt(q)-'a');
                        break;
                    }
                    p++;q++;
                }
            }
            return fun(K,adj);
    
        }
         public String fun(int V, List<Integer>[] adj) {
            int inDegree[] = new int[V];
            String ans="";
            
            for (int i = 0; i < V; i++) {
                for (int it : adj[i]) inDegree[it]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) queue.add(i);
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                ans+=(char)(node+97);
                for (int it : adj[node]) {
                    inDegree[it]--;
                    if (inDegree[it] == 0) queue.offer(it);
                }
            }
            return ans;
        }
}

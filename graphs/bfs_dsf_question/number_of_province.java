package graphs.bfs_dsf_question;

public class number_of_province {
    public static int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int visited[]=new int[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int isConnected[][],int visited[],int i){
        visited[i]=1;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && visited[j]==0){
                dfs(isConnected,visited,j);
            }
        }
    }
}

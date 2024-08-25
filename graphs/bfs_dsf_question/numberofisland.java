package graphs.bfs_dsf_question;

import java.util.LinkedList;
import java.util.Queue;

class IslandPair {
    int first;
    int second;
    
    public IslandPair(int i, int j) {
        first = i;
        second = j;
    }
}
public class numberofisland {
        public static int numIslands(char[][] grid) {
           int n=grid.length;
           int m=grid[0].length;
           int visited[][]=new int[n][m];
           int count=0;
           for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0&&grid[i][j]=='1'){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
           }
           return count;
        }
        public static void bfs(int row,int column,int[][] visited,char[][] grid){
            visited[row][column]=1;
            int n=grid.length;
            int m=grid[0].length;
            Queue<IslandPair> queue=new LinkedList<IslandPair>();
            queue.offer(new IslandPair(row,column));
            while(!queue.isEmpty()){
                int ro=queue.peek().first;
                int co=queue.peek().second;
                queue.poll();
                for(int i=-1;i<=1;i++){
                    for(int j=-1;j<=1;j++){
                        int nrow=ro+i;
                        int ncol=co+j;
                        if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&visited[nrow][ncol]==0&&grid[nrow][ncol]=='1'){
                            visited[nrow][ncol]=1;
                            queue.offer(new IslandPair(nrow,ncol));
                        }
                    }
                }
            }
        }
    }
    
    
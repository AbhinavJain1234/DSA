package graphs.bfs_dsf_question;

import java.util.LinkedList;
import java.util.Queue;

class numberofenclavePair{
    int row;
    int column;
    numberofenclavePair(int i,int j){
        row=i;column=j;
    }
}
public class numberofenclave {
    private static boolean isValid(int i, int j, 
                            int n, int m) {
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }
    public static int enclave(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<numberofenclavePair> queue=new LinkedList<>();
        int visited[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==n||j==m)queue.offer(new numberofenclavePair(i,j));
            }
        }
        while (!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;i++){
                numberofenclavePair val=queue.poll();
                visited[val.row][val.column]=-1;
                int delCol[]={0,1,0,-1};
                int delRow[]={-1,0,1,0};
                for(int j=0;j<4;j++){
                    int nRow=val.row+delRow[i];
                    int nCol=val.column+delCol[i];
                    if(isValid(nRow, nCol, n, m) && 
                   grid[nRow][nCol] == 1 
                   && visited[nRow][nCol] == 0) {
                    
                    /* Mark the new cell as visited
                    and add it to the queue */
                    visited[nRow][nCol] = -1;
                    queue.offer(new numberofenclavePair(nRow, nCol));
                }

                }
            }

        }
        int count = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++){
                if(grid[i][j] == 1 &&  visited[i][j]==0)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}

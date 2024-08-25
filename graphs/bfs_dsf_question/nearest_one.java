package graphs.bfs_dsf_question;
import java.util.LinkedList;
import java.util.Queue;

public class nearest_one {
    private static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int ans[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int count=1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};

                for (int q = 0; q < 4; q++) {
                    int nRow = row + delRow[q];
                    int nCol = col + delCol[q];

                    if (isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 0&&ans[nRow][nCol]==0) {
                        ans[nRow][nCol]=count;
                        queue.offer(new int[]{nRow, nCol});
                    }
                }
            }
            count++;
        }
        return ans;
    }
    public static void main(String[] args) {
        nearest_one obj=new nearest_one();
        int grid[][]={{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        obj.nearest(grid);
    }
}
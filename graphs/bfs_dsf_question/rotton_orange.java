package graphs.bfs_dsf_question;
import java.util.LinkedList;
import java.util.Queue;

class rotton_orange {
    private static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newRotten = false;

            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};

                for (int q = 0; q < 4; q++) {
                    int nRow = row + delRow[q];
                    int nCol = col + delCol[q];

                    if (isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        queue.offer(new int[]{nRow, nCol});
                        newRotten = true;
                    }
                }
            }

            if (newRotten) {
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        rotton_orange obj = new rotton_orange();
        System.out.println(obj.orangesRotting(grid));
    }
}

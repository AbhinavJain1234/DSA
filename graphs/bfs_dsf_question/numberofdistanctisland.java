package graphs.bfs_dsf_question;

import java.util.*;

class numberofdistanctisland {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};

    private boolean isValid(int i, int j, int n, int m) {
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }

    private void dfs(int row, int col, int[][] grid, 
                     boolean[][] visited, List<List<Integer>> path, 
                     int base_row, int base_col) {
                         
        int n = grid.length;
        int m = grid[0].length;

        // Add relative position of the current cell
        path.add(Arrays.asList(row-base_row, col-base_col));
        
        // Traverse the 4 neighbors
        for(int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(isValid(nRow, nCol, n, m) && 
               grid[nRow][nCol] == 1 && 
               !visited[nRow][nCol]) {
                   
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, grid, visited, path, base_row, base_col);
            }
        }
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<List<List<Integer>>> st = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    List<List<Integer>> path = new ArrayList<>();
                    dfs(i, j, grid, visited, path, i, j);
                    st.add(path);
                }
            }
        }
        
        return st.size();
    }
}

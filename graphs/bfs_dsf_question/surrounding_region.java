package graphs.bfs_dsf_question;

public class surrounding_region {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};

    public char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];

        // Check first and last row for 'O's and run DFS
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && mat[0][j] == 'O') {
                dfs(0, j, vis, mat);
            }
            if (!vis[n-1][j] && mat[n-1][j] == 'O') {
                dfs(n-1, j, vis, mat);
            }
        }

        // Check first and last column for 'O's and run DFS
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat);
            }
            if (!vis[i][m-1] && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat);
            }
        }

        // Replace all unvisited 'O' cells with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    private void dfs(int row, int col, boolean[][] vis, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (isValid(nRow, nCol, n, m) && mat[nRow][nCol] == 'O' && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, mat);
            }
        }
    }
}

package graphs.shortest_path;

import java.util.LinkedList;
import java.util.Queue;

/**
 * shortestpathinabinarymaze
 */
public class shortestpathinabinarymaze {

     private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        // Edge case: if source or destination is not walkable
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
            return -1;
        }

        // If source is the same as destination
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        // Initialize BFS queue and visited matrix
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // Start BFS from the source
        queue.offer(new int[]{source[0], source[1], 0}); // [row, col, distance]
        visited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0], currCol = current[1], currDist = current[2];

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = currRow + rowDir[i];
                int newCol = currCol + colDir[i];

                // Check if new position is within bounds and walkable
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    // Check if we've reached the destination
                    if (newRow == destination[0] && newCol == destination[1]) {
                        return currDist + 1;
                    }
                    
                    // Mark new position as visited and add to queue
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, currDist + 1});
                }
            }
        }

        // If we finish BFS without finding the destination, return -1
        return -1;
    }
}
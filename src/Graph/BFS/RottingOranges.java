package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows  = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] currentPosition = q.poll();
                int row = currentPosition[0];
                int col = currentPosition[1];

                for (int[] d : directions) {
                    int nx = row + d[0];
                    int ny = col + d[1];

                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}

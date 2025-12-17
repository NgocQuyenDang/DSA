package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int maxArea = Integer.MIN_VALUE;

        int rows =  grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int area = 0;
                    area += 1;
                    queue.add(new int[] {i, j});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int[] d: directions) {
                            int nx = cur[0] + d[0];
                            int ny = cur[1] + d[1];

                            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                                area += 1;
                                grid[nx][ny] = 0;
                                queue.add(new int[] {nx, ny});
                            }
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}

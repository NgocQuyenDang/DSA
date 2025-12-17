package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new int[] {i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] d : directions) {
                            int newRow = cur[0] + d[0];
                            int newCol = cur[1] + d[1];

                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                                q.add(new int[] {newRow, newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(new NumberOfIsland().numIslands(grid));
    }
}

package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] safe = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') q.offer(new int[]{i, 0});
            if (board[i][cols - 1] == 'O') q.offer(new int[]{i, cols - 1});
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') q.offer(new int[]{0, j});
            if (board[rows - 1][j] == 'O') q.offer(new int[]{rows - 1, j});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            if (safe[row][col]) { continue; }
            safe[row][col] = true;

            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols &&  board[x][y] == 'O') {
                    q.offer(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!safe[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

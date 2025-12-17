package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int rows = image.length;
        int cols = image[0].length;
        int origin = image[sr][sc];
        image[sr][sc] = color;

        q.add(new int[] {sr, sc});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();

                int row = cur[0];
                int col = cur[1];

                for (int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&  image[newRow][newCol] != color
                    && image[newRow][newCol] == origin) {
                        image[newRow][newCol] = color;
                        q.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
        return image;
    }
}

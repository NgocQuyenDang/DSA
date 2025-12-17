package Graph.Algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[points.length];
        int minCost = 0;

        heap.offer(new int[]{0, 0});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int v = cur[0];
            int w = cur[1];

            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            minCost += w;

            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[i][0] - points[v][0]) + Math.abs(points[i][1] - points[v][1]);
                    heap.offer(new int[]{i, dist});
                }
            }
        }
        return minCost;
    }
}

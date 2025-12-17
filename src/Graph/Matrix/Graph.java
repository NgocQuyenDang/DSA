package Graph.Matrix;

import java.util.*;

public class Graph{
    
    public int[] djikstra(int[][] a, int x, int y){
        // TODO
        int n = a.length;
        int[] dist = new int[n];
        int[] trace = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(trace, -1);

        dist[x] = 0;

        Queue<int[]> pq = new PriorityQueue<>((c, d) -> c[0] - d[0]);
        pq.offer(new int[] {0, x});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int d = cur[0];
            int v = cur[1];

            if (visited[v]) continue;

            visited[v] = true;

            for (int j = 0; j < n; j++) {
                if (a[v][j] > 0) {
                    int w = d + a[v][j];
                    if (w < dist[j]) {
                        dist[j] = w;
                        trace[j] = v;
                        pq.offer(new int[] {w, j});
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int cur = y;
        while (cur != -1) {
            ans.add(cur);
            cur = trace[cur];
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
}
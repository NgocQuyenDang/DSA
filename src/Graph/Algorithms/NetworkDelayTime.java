package Graph.Algorithms;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            adj.get(u).add(new int[]{v, w});
        }

        int[] dist =  new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{d + w, v});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if  (dist[i] == Integer.MAX_VALUE) return -1;
            else ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}

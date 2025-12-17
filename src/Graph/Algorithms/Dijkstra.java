package Graph.Algorithms;

import java.util.*;

public class Dijkstra {
    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
        int V = adj.size();

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] p : adj.get(u)) {
                int v = p[0];
                int w = p[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d);
        }
        return result;
    }
}

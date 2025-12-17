package Graph.BFS;

import java.util.*;

public class FindPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        if (list.size() == 0) {
            return false;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int v : list.get(cur)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    q.offer(v);
                }
            }
            if (visited.contains(destination)) {
                return true;
            }
        }
        return false;
    }
}

package FinalExam.Task5;

import java.util.*;
@SuppressWarnings({"unchecked", "deprecation"})
class Graph{
   private List<List<Integer>> adj;
    private boolean[] visited;
    private int n;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[n];
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    public List<int[]> getEdges() {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int v :  adj.get(i)) {
                if (i < v) {
                    edges.add(new int[]{i, v});
                }
            }
        }
        return edges;
    }

    // Phuong thuc kiem tra xem do thi co chu trinh hay khong
    public boolean hasCycle() {
        if (n == 0) return false;
        DSU dsu = new DSU(n);
        List<int[]> edges = getEdges();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.find(u) == dsu.find(v)) {
                return true;
            } else if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
            }
        }
        return false;
    }

    public boolean dfs(int u, int parent, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if(!visited[v]) {
                if (dfs(v, u, visited)) {
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}

class DSU {
    int[] parent, rank;

    public DSU(int v) {
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    public void union(int x, int y) {
        int s1 = find(x), s2 = find(y);

        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1]++;
            }
        }
    }
}

package Graph.Matrix.Kruskal;

import java.util.*;

class Kruskal {
    int V;
    List<Edge> edges;

    Kruskal(int vertices, List<List<Graph.Pair>> adjList) { // khởi tạo class, chuyển adjList sang danh sách cạnh
        V = vertices;
        Graph g = new Graph(V);
        g.adjList = adjList;
        edges = g.getAllEdges();
    }


    public void kruskalMST() {
        Collections.sort(edges, Comparator.comparingInt(a -> a.weight));
        DSU dsu = new DSU(V);
        int count = 0;
        System.out.println("Các cạnh trong Minimum Spanning Tree: ");
        for (Edge e : edges) {
            int s = e.src;
            int d = e.dest;
            int w = e.weight;

            if (dsu.find(s) != dsu.find(d)) {
                dsu.union(s, d);
                System.out.println(s + " -- " + d + " == " + w);
                if (++count == V - 1) {
                    break;
                }
            }
        }
    }
}

class DSU {
    int[] parent, rank;

    public DSU(int V) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
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

    public void union(int x , int y) {
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

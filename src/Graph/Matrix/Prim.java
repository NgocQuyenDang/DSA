package Graph.Matrix;

import java.util.*;

public class Prim {
    private int numVertices;
    private int[][] graph;

    /**
     * Khởi tạo đối tượng với ma trận kề của đồ thị.
     *
     * @param graph Ma trận kề thể hiện trọng số các cạnh. 9999 biểu thị không có cạnh.
     */
    public Prim(int[][] graph) {
        this.numVertices = graph.length;
        this.graph = graph;
    }

    /**
     * Thực hiện thuật toán Prim để tìm MST.
     *
     * @return mảng parent, trong đó parent[i] là đỉnh cha của đỉnh i trong MST.
     */
    public int[] primMST() {
        int V = numVertices;

        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0 ; i < V - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && graph[u][v] != Integer.MAX_VALUE && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        return parent;
    }

    public int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

}

package Graph.Matrix;

import java.util.*;

class DFS {
    
    public void DFS(List<List<Integer>> adjList, int start) {
        // TODO
        boolean[] visited = new boolean[adjList.size()];
        dfs(adjList, start, visited);
    }

    public void dfs(List<List<Integer>> adjList, int start, boolean[] visited) {
        visited[start] = true;

        System.out.print(start + " ");

        for (int v : adjList.get(start)) {
            if (!visited[v]) {
                dfs(adjList, v, visited);
            }
        }
    }
}
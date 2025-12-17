//package Graph.DFS;
//
//import java.util.*;
//
//public class FindPathExist {
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        if (list.size() == 0) {
//            return false;
//        }
//
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            list.get(u).add(v);
//            list.get(v).add(u);
//        }
//
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(source);
//        Set<Integer> visited = new HashSet<>();
//
//
//    }
//
//    public boolean dfs(List<List<Integer>> list, int source, int destination, Set<Integer> visited) {
//        if (source == destination) {
//            return true;
//        }
//
//        visited.add(source);
//        for (int neighbor : list.get(source)) {
//            if (!visited.contains(neighbor)) {
//                visited.add(neighbor);
//
//                if (dfs(list, neighbor, destination, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}

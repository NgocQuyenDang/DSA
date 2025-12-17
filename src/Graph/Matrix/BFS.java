package Graph.Matrix;

import java.io.*;
import java.util.*;
@SuppressWarnings({"unchecked", "deprecation"})
public class BFS
{
	public static List<List<Integer>> readGraphFromFile(String fileName) {
	    // TODO
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int n = Integer.parseInt(br.readLine());

			List<List<Integer>> adjList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				adjList.add(new ArrayList<>());
			}

			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 1; j < line.length; j++) {
					adjList.get(i).add(Integer.parseInt(line[j]));
				}
			}
			return adjList;
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return null;
    }
	
	public void bfs(List<List<Integer>> adjList, int start) {
	   // TODO
		int n = adjList.size();

		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int v : adjList.get(cur)) {
				if (!visited[v]) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
    }
}

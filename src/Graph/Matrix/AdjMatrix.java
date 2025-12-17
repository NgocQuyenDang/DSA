package Graph.Matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@SuppressWarnings({"unchecked", "deprecation"})
public class AdjMatrix {
	
	private int[][] matrix;// ma trận kề
	private String[] v;// danh sách các đỉnh
	private int n;// số đỉnh
	
	public void loadGraphFromFile(String fileName){
	    // TODO
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int n = Integer.parseInt(br.readLine());
			matrix = new int[n][n];
			v = new String[n];
			for (int i = 0; i < n; i++) {
				v[i] = br.readLine();
			}

			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(line[j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public  List<String> getAdjList(){
	    // TODO
		List<String> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++){
			List<String> subList = new ArrayList<>();
			subList.add(v[i]);
			for (int j = 0; j < n; j++){
				if (matrix[i][j] == 1) {
					subList.add(v[j]);
				}
			}
			String s = String.join("->", subList);
			adjList.add(s);
		}
		return adjList;
	}

}
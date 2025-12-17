package Graph.Matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@SuppressWarnings({"unchecked", "deprecation"})
public class GraphDegree {
	
	private int[][] matrix;// ma trận kề
	private String[] v;// danh sách các đỉnh
	private int n;// số đỉnh
	
	public void loadGraphFromFile(String fileName) {
	    // TODO
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			n = Integer.parseInt(br.readLine());
			matrix = new int[n][n];
			v = new String[n];

			for ( int i = 0; i < n; i++) {
				v[i] = br.readLine();
			}
			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(line[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getDegree(){
		// TODO
		int[] degree = new int[n];
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					count++;
				}
			}
			degree[i] = count;
		}
		return degree;
	}
	
}
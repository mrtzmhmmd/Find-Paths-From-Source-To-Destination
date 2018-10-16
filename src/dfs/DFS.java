package dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	private int v;
	private ArrayList<Integer>[] adjList;

	public DFS(int[][] arr) {
		setV(arr.length);
		initAdjList();
		edge(arr);
	}

	private void setV(int v) {
		this.v = v;
	}

	@SuppressWarnings("unchecked")
	private void initAdjList() {
		adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	private void edge(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					addEdge(i, j);
				}
			}
		}
	}

	private void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	public void printAllPaths(int s, int d) {
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();
		pathList.add(s);
		printAllPathsUtil(s, d, isVisited, pathList);
	}

	private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
		isVisited[u] = true;
		if (u.equals(d)) {
			System.out.println(localPathList);
		}

		for (Integer i : adjList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);
				localPathList.remove(i);
			}
		}
		isVisited[u] = false;
	}
}
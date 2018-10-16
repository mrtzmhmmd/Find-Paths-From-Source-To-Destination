package bfs;

import java.util.Hashtable;
import java.util.LinkedList;

public class BFS {
	public int count;
	public Hashtable<Object, Object> hash;
	private String start = "0";
	private String end;
	private int[][] arr;

	public BFS(int[][] arr) {
		hash = new Hashtable<>();
		count = 0;
		setEnd(String.valueOf(arr.length - 1));
		setArr(arr);
	}

	private void setArr(int[][] arr) {
		this.arr = arr;
	}

	private void setEnd(String end) {
		this.end = end;
	}

	public void bfs() {
		GraphStructure graph = new GraphStructure();
		int len = Integer.valueOf(end) + 1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (arr[i][j] == 1) {
					graph.addEdge(String.valueOf(i), String.valueOf(j));
				}
			}
		}
		LinkedList<String> visited = new LinkedList<>();
		visited.add(start);
		breadthFirst(graph, visited);
	}

	@SuppressWarnings("unlikely-arg-type")
	private void breadthFirst(GraphStructure graph, LinkedList<String> visited) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		for (String node : nodes) {
			if (visited.contains(nodes)) {
				continue;
			}
			if (node.equals(end)) {
				count++;
				visited.add(node);
				printPath(count, visited);
				visited.removeLast();
				break;
			}
		}

		for (String node : nodes) {
			if (visited.contains(node) || node.equals(end)) {
				continue;
			}
			visited.addLast(node);
			breadthFirst(graph, visited);
			visited.removeLast();
		}
	}

	private void printPath(int count, LinkedList<String> visited) {
		String temp = "";
		for (String node : visited) {
			if (node.equals(end)) {
				temp = temp + node;
			} else {
				temp = temp + node + ", ";
			}
		}
		System.out.println("Available Path " + count + ": " + temp);
		hash.put(count, temp);
	}
}
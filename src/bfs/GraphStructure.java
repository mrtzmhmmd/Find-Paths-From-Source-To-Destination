package bfs;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class GraphStructure {
	private Map<String, LinkedHashSet<String>> map = new HashMap<>();

	public void addEdge(String node1, String node2) {
		LinkedHashSet<String> adjacent = map.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet<>();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}

	public boolean isConnected(String node1, String node2) {
		Set<?> adjacent = map.get(node1);
		if (adjacent == null) {
			return false;
		}
		return adjacent.contains(node2);
	}

	public LinkedList<String> adjacentNodes(String last) {
		LinkedHashSet<String> adjacent = map.get(last);
		if (adjacent == null) {
			return new LinkedList<>();
		}
		return new LinkedList<>(adjacent);
	}
}
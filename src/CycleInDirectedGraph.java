/**
 * To detect a back edge, we can keep track of vertices currently in recursion
 * stack of function for DFS traversal. If we reach a vertex that is already 
 * in the recursion stack, then there is a cycle in the tree. The edge that
 * connects current vertex to the vertex in the recursion stack is a back
 * edge. We have used recStack[] array to keep track of vertices in the
 * recursion stack.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println(graph.isCyclic() ? "Graph contains cycle" : "Graph doesn't contain cycle");
	}
}

class Graph{
	private final int V;
	private final List<List<Integer>> adj;

	public Graph(int v) {
		this.V = v;
		adj = new ArrayList<>(V);
		for(int i=0; i<V; i++) {
			adj.add(new LinkedList<>());
		}
	}

	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
		if (recStack[i]) {
			return true;
		}
		if (visited[i]) {
			return false;
		}
		visited[i] = true;
		recStack[i] = true;
		List<Integer> children = adj.get(i);
		for (Integer c: children) {
			if (isCyclicUtil(c, visited, recStack)) {
				return true;
			}
		}
		recStack[i] = false;
		return false;
	}

	public void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}
}

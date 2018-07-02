/**
 *We do a DFS traversal of the given graph. For every visited vertex ‘v’, if
 *there is an adjacent ‘u’ such that u is already visited and u is not parent
 *of v, then there is a cycle in graph. If we don’t find such an adjacent 
 *for any vertex, we say that there is no cycle. The assumption of this approach
 * is that there are no parallel edges between any two vertices. 
 */

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {

	public static void main(String[] args) {
		Graph1 g1 = new Graph1(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(g1.isCyclic() ? "Graph contains cycle"
        		                         : "Graph doesn't contains cycle");
 
        Graph1 g2 = new Graph1(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.isCyclic() ? "Graph contains cycle"
        								 : "Graph doesn't contains cycle");
	}

}

class Graph1 {
	private int V;
	private LinkedList<Integer> adj[];

	public Graph1(int v) {
		V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i) {
        	adj[i] = new LinkedList();
        }
	}

	public boolean isCyclic() {
		Boolean[] visited = new Boolean[V];
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		
		for(int u=0; u<V; u++) {
			if(!visited[u]){
				if (isCyclicUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int v, Boolean[] visited, int parent) {
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			if(!visited[i]){
				if (isCyclicUtil(i, visited, v))
                    return true;
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
        adj[w].add(v);
	}
	
}

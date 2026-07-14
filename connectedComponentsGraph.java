/*Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.



A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.


Example 1



Input: V=4, edges=[[0,1],[1,2]]

Output: 2

Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.

Example 2

Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]

Output: 3

Explanation:

The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.

The edge [4, 5] forms another connected component with vertices {4, 5}.

Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).

 
Constraints

1 ≤ V, edges.length ≤ 104
0 <= edges[i][0], edges[i][1] <= V-1
All edges are unique */

import java.util.*;

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        // 1. Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }
        
        // 2. Traverse the graph to count components
        boolean[] visited = new boolean[V];
        int connectedComponents = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i, adj, visited);
            }
        }
        
        return connectedComponents;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
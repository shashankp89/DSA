/*Given an undirected connected graph with V vertices numbered from 0 to V-1, the task is to implement both Depth First Search (DFS) and Breadth First Search (BFS) traversals starting from the 0th vertex.



The graph is represented using an array/vector of edges, where each element is a pair [u, v] indicating an undirected edge between vertex u and vertex v.


Example 1





Input: V = 5, edges = [ [0, 1], [0, 2], [0, 3], [2, 4] ]

Output:[0, 2, 4, 3, 1], [0, 2, 3, 1, 4]

Explanation:

DFS: Start from vertex 0. Visit vertex 2, then vertex 4, backtrack to vertex 0, then visit vertex 3, and finally vertex 1. The traversal is 0 → 2 → 4 → 3 → 1.

BFS: Start from vertex 0. Visit vertices 2, 3, and 1 (in the order they appear in the adjacency list). Then, visit vertex 4 from vertex 2. The traversal is 0 → 2 → 3 → 1 → 4.

Example 2

Input: V = 4, edges = [ [0, 1], [0, 3], [1, 2] ]

Output: [0, 1, 2, 3], [0, 1, 3, 2]

Explanation:

DFS: Start from vertex 0. Visit vertex 1, then vertex 2, backtrack to vertex 0, then visit vertex 3. The traversal is 0 → 1 → 2 → 3.

BFS: Start from vertex 0. Visit vertices 1 and 3, then visit vertex 2 from vertex 1. The traversal is 0 → 1 → 3 → 2.

Now your turn!

Input: V = 3, edges = [ [0, 1], [0, 2] ]

Output:

Pick your answer


[0, 1, 2], [0, 1, 2]

[0, 2, 1], [2, 0, 1]

[1, 0, 2], [0, 2, 1]

[0, 2, 1], [1, 2, 0]
Constraints

E= Number of Edges
1 ≤ V, E ≤ 104 */


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = this.buildAdjList(V, edges);
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<Integer>();
        
        this.dfs(0, adj, visited, result);
        
        return result;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        
        for (int i = 0; i < adj.get(node).size(); i = i + 1) {
            int neighbor = adj.get(node).get(i);
            if (visited[neighbor] == false) {
                this.dfs(neighbor, adj, visited, result);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = this.buildAdjList(V, edges);
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(0);
        visited[0] = true;
        
        while (queue.isEmpty() == false) {
            int node = queue.poll();
            result.add(node);
            
            for (int i = 0; i < adj.get(node).size(); i = i + 1) {
                int neighbor = adj.get(node).get(i);
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
    
    private List<List<Integer>> buildAdjList(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < V; i = i + 1) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.size(); i = i + 1) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
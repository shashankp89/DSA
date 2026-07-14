/*Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.

Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).


Example 1





Input: V = 6, adj= [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]

Output: True

Explanation: The graph contains a cycle: 0 ->1 -> 2 -> 5 -> 4 -> 1.

Example 2



Input: V = 4, adj= [[1, 2], [0], [0, 3], [2]]

Output: False

Explanation: The graph does not contain any cycles.

Now your turn!

Input: V = 4, adj= [[1, 2], [0, 2], [0, 1, 3], [2]]

Output:

Pick your answer


True

False
Constraints

E=number of edges
1 ≤ V, E ≤ 104 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean bfs(int startNode, boolean[] visited, List<Integer>[] adj) {
        Queue<int[]> queue = new LinkedList<>();
        // Store {current_node, parent_node}
        queue.add(new int[]{startNode, -1});
        visited[startNode] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Visited and not the parent means we found a cycle
                    return true;
                }
            }
        }
        
        return false;
    }
}
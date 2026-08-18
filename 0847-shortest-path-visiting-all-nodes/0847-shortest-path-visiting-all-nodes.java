import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] g) {
        
        int n = g.length;
        
        if(n == 1){
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];
        
        for(int i = 0; i < n; i = i + 1){
            q.add(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        }
        
        int t = (1 << n) - 1;
        
        while(q.isEmpty() == false){
            int[] c = q.poll();
            int u = c[0];
            int m = c[1];
            int d = c[2];
            
            if(m == t){
                return d;
            }
            
            for(int v : g[u]){
                int nm = m | (1 << v);
                
                if(vis[v][nm] == false){
                    vis[v][nm] = true;
                    q.add(new int[]{v, nm, d + 1});
                }
            }
        }
        
        return 0;
    }
}
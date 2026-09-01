import java.util.ArrayDeque;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        
        int m = classroom.length;
        int n = classroom[0].length();
            
        char[][] grid = new char[m][n];
        int[][] lIdx = new int[m][n];
        int lCount = 0;
        int sx = -1;
        int sy = -1;
        
        for(int i = 0; i < m; i = i + 1){
            for(int j = 0; j < n; j = j + 1){
                grid[i][j] = classroom[i].charAt(j);
                
                if(grid[i][j] == 'S'){
                    sx = i;
                    sy = j;
                } else if(grid[i][j] == 'L'){
                    lIdx[i][j] = lCount;
                    lCount = lCount + 1;
                }
            }
        }
        
        if(lCount == 0){
            return 0;
        }
        
        int tMask = (1 << lCount) - 1;
         
        int max = m * n * (1 << lCount);
        int[] maxE = new int[max];
        
        for(int i = 0; i < max; i = i + 1){
            maxE[i] = -1;
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0, energy});
        
        int sid = (sx * n + sy) * (1 << lCount) + 0;
        maxE[sid] = energy;
        
        int[] d = {-1, 0, 1, 0, -1};
        int steps = 0;
        
        while(q.isEmpty() == false){
            int sz = q.size();
            
            for(int i = 0; i < sz; i = i + 1){
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];
                int mask = c[2];
                int ce = c[3];
                
                for(int k = 0; k < 4; k = k + 1){
                    int nx = cx + d[k];
                    int ny = cy + d[k + 1];
                    
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 'X'){
                        continue;
                    }
                    
                    int ne = ce - 1;
                    
                    if(ne < 0){
                        continue;
                    }
                    
                    int nm = mask;
                    
                    if(grid[nx][ny] == 'L'){
                        nm = nm | (1 << lIdx[nx][ny]);
                    }
                     
                    if(nm == tMask){
                        return steps + 1;
                    }
                    
                    if(grid[nx][ny] == 'R'){
                        ne = energy;
                    }
 
                    if(ne == 0){
                        continue;
                    }
                    
                    int id = (nx * n + ny) * (1 << lCount) + nm;
                     
                    if(ne > maxE[id]){
                        maxE[id] = ne;
                        q.offer(new int[]{nx, ny, nm, ne});
                    }
                }
            }
            steps = steps + 1;
        }
        
        return -1;
    }
}
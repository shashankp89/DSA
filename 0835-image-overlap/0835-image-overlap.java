import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
         
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) ones1.add(new int[]{r, c});
                if (img2[r][c] == 1) ones2.add(new int[]{r, c});
            }
        }
         
        int[][] vectorCounts = new int[2 * n][2 * n];
        int maxOverlaps = 0;
         
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dx = p2[0] - p1[0] + n;
                int dy = p2[1] - p1[1] + n;
                
                vectorCounts[dx][dy]++;
                 
                if (vectorCounts[dx][dy] > maxOverlaps) {
                    maxOverlaps = vectorCounts[dx][dy];
                }
            }
        }
        
        return maxOverlaps;
    }
}
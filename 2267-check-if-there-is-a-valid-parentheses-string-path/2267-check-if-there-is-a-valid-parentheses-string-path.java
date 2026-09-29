class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        int maxBal = m + n;
        boolean[][] dp = new boolean[n][maxBal + 1];
        
        for (int i = 0; i < m; i++) {
            boolean[][] nextDp = new boolean[n][maxBal + 1];
            for (int j = 0; j < n; j++) {
                int diff = grid[i][j] == '(' ? 1 : -1;
                
                if (i == 0 && j == 0) {
                    nextDp[0][1] = true;
                    continue;
                }
                
                for (int k = 0; k <= maxBal; k++) {
                    int prevBal = k - diff;
                    if (prevBal >= 0 && prevBal <= maxBal) {
                        if (i > 0 && dp[j][prevBal]) {
                            nextDp[j][k] = true;
                        }
                        if (j > 0 && nextDp[j - 1][prevBal]) {
                            nextDp[j][k] = true;
                        }
                    }
                }
            }
            dp = nextDp;
        }
        
        return dp[n - 1][0];
    }
}
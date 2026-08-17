class Solution {
    private int[][] dp;
    private int[] prefix;
    
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        dp = new int[n][n];
        prefix = new int[n + 1];
        
        for(int i=0; i<n; i++){
            prefix[i + 1] = prefix[i] + stoneValue[i];
            
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(stoneValue, 0, n - 1);
    }
    
    private int solve(int[] stoneValue, int l, int r){
        
        if(l == r){
            return 0;
        }
        
        if(dp[l][r] != -1){
            return dp[l][r];
        }
        
        int maxScore = 0;
        
        for(int i=l; i<r; i++){
            
            int leftSum = prefix[i + 1] - prefix[l];
            int rightSum = prefix[r + 1] - prefix[i + 1];
            
            if(leftSum < rightSum){
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, l, i));
            } else if(leftSum > rightSum){
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, i + 1, r));
            } else {
                maxScore = Math.max(maxScore, leftSum + Math.max(solve(stoneValue, l, i), solve(stoneValue, i + 1, r)));
            }
        }
        
        return dp[l][r] = maxScore;
    }
}
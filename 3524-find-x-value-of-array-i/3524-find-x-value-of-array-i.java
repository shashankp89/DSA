class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] ans = new long[k];
        long[][] dp = new long[n][k];
        
        for (int i = 0; i < n; i++) {
            int numMod = nums[i] % k;
            dp[i][numMod] += 1;
            
            if (i > 0) {
                for (int r = 0; r < k; r++) {
                    if (dp[i - 1][r] > 0) {
                        int nextMod = (int) ((1L * r * numMod) % k);
                        dp[i][nextMod] += dp[i - 1][r];
                    }
                }
            }
            
            for (int r = 0; r < k; r++) {
                ans[r] += dp[i][r];
            }
        }
        
        return ans;
    }
}
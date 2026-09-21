class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            int numMod = num % k;
            
            nextDp[numMod] += 1;
            
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nextMod = (int) ((1L * r * numMod) % k);
                    nextDp[nextMod] += dp[r];
                }
            }
            
            for (int r = 0; r < k; r++) {
                ans[r] += nextDp[r];
            }
            
            dp = nextDp;
        }
        
        return ans;
    }
}
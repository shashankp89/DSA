import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        
        long ans = 0;
        long mod = 1_000_000_007;
        
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int j = 0; j < 32; j++) {
                if (count[j] > 0) {
                    currentNum |= (1L << j);
                    count[j]--;
                }
            }
            ans = (ans + (currentNum * currentNum) % mod) % mod;
        }
        
        return (int) ans;
    }
}
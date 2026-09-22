import java.util.*;

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int blockSize = (int) Math.sqrt(n) + 1;
        int[] blockProd = new int[blockSize];
        int[][] blockCount = new int[blockSize][k];
        
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }
        
        for (int b = 0; b < blockSize; b++) {
            rebuildBlock(nums, k, b, blockSize, blockProd, blockCount);
        }
        
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            nums[idx] = queries[q][1] % k;
            
            int b = idx / blockSize;
            rebuildBlock(nums, k, b, blockSize, blockProd, blockCount);
            
            int start = queries[q][2];
            int target = queries[q][3];
            
            int count = 0;
            int currP = 1;
            
            int startB = start / blockSize;
            int endOfFirstBlock = Math.min(n, (startB + 1) * blockSize);
            
            for (int i = start; i < endOfFirstBlock; i++) {
                currP = (currP * nums[i]) % k;
                if (currP == target) count++;
            }
            
            for (int currB = startB + 1; currB * blockSize < n; currB++) {
                for (int rem = 0; rem < k; rem++) {
                    if (blockCount[currB][rem] > 0) {
                        int actualRem = (currP * rem) % k;
                        if (actualRem == target) {
                            count += blockCount[currB][rem];
                        }
                    }
                }
                currP = (currP * blockProd[currB]) % k;
            }
            ans[q] = count;
        }
        return ans;
    }
    
    private void rebuildBlock(int[] nums, int k, int b, int blockSize, int[] blockProd, int[][] blockCount) {
        int n = nums.length;
        int startIdx = b * blockSize;
        if (startIdx >= n) return;
        int endIdx = Math.min(n, startIdx + blockSize);
        
        Arrays.fill(blockCount[b], 0);
        int p = 1;
        for (int i = startIdx; i < endIdx; i++) {
            p = (p * nums[i]) % k;
            blockCount[b][p]++;
        }
        blockProd[b] = p;
    }
}
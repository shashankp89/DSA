import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squares);
        
        int positiveCount = (n + 1) / 2;
        int negativeCount = n / 2;
        
        long score = 0;
        
        for (int i = n - 1; i >= n - positiveCount; i--) {
            score += squares[i];
        }
        
        for (int i = 0; i < negativeCount; i++) {
            score -= squares[i];
        }
        
        return score;
    }
}
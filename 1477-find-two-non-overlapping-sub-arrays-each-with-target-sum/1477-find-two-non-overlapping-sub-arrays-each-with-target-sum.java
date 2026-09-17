class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
         
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0, sum = 0;
        int minTotalLength = Integer.MAX_VALUE;
        int bestSingleSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
             
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int currentLen = right - left + 1;
                 
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minTotalLength = Math.min(minTotalLength, currentLen + minLen[left - 1]);
                }
               
                bestSingleSoFar = Math.min(bestSingleSoFar, currentLen);
            }
 
            minLen[right] = bestSingleSoFar;
        }
        
        return minTotalLength == Integer.MAX_VALUE ? -1 : minTotalLength;
    }
}
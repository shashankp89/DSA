class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        
        for (int num : nums) {
            if (num > high) {
                high = num;
            }
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = isValid(nums, threshold, mid);
            
            if (possible == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[] nums, int threshold, int divisor) {
        long sum = 0;
        
        for (int num : nums) {
            sum = sum + (num / divisor);
            
            if (num % divisor != 0) {
                sum = sum + 1;
            }
        }
        
        if (sum <= threshold) {
            return true;
        } else {
            return false;
        }
    }
}
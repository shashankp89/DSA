class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        for (int num : nums) {
            if (num > low) {
                low = num;
            }
            high = high + num;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = isValid(nums, k, mid);
            
            if (possible == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays = subarrays + 1;
                currentSum = num;
            } else {
                currentSum = currentSum + num;
            }
        }
        
        if (subarrays <= k) {
            return true;
        } else {
            return false;
        }
    }
}
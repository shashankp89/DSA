class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for (int w : weights) {
            if (w > low) {
                low = w;
            }
            high = high + w;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = isValid(weights, days, mid);
            
            if (possible == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded = daysNeeded + 1;
                currentLoad = w;
            } else {
                currentLoad = currentLoad + w;
            }
        }
        
        if (daysNeeded <= days) {
            return true;
        } else {
            return false;
        }
    }
}
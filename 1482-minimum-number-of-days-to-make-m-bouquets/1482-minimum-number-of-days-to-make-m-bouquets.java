class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        long totalNeeded = (long) m * k;
        if (totalNeeded > n) {
            return -1;
        }
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for (int day : bloomDay) {
            if (day < low) low = day;
            if (day > high) high = day;
        }
        
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = canMake(bloomDay, m, k, mid);
            
            if (possible == true) {
                ans = mid;         
                high = mid - 1;    
            } else {
                low = mid + 1;     
            }
        }
        
        return ans;
    }
    
    private boolean canMake(int[] bloomDay, int m, int k, int currentDay) {
        int bouquets = 0;
        int adjacent = 0;
        
        for (int bloom : bloomDay) {
            if (bloom <= currentDay) {
                adjacent = adjacent + 1;
                
                if (adjacent == k) {
                    bouquets = bouquets + 1;
                    adjacent = 0; 
                }
            } else {
                adjacent = 0; 
            }
        }
        
        if (bouquets >= m) {
            return true;
        } else {
            return false;
        }
    }
}
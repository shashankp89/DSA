class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
         
        for (int p : piles) {
            if (p > high) {
                high = p;
            }
        }
        
        int ans = high;
         
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = canEatAll(piles, h, mid);
            
            if (possible == true) {
                ans = mid;        
                high = mid - 1;    
            } else {
                low = mid + 1;      
            }
        }
        
        return ans;
    }
     
    private boolean canEatAll(int[] piles, int h, int speed) {
        long hours = 0;
        
        for (int p : piles) {
             
            hours = hours + (p / speed);
             
            if (p % speed != 0) {
                hours = hours + 1;
            }
        }
        
        if (hours <= h) {
            return true;
        } else {
            return false;
        }
    }
}
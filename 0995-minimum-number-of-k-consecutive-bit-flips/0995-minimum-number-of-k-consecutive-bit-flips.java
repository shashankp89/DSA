class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int n = nums.length;
        int flips = 0;
        int currentFlips = 0;
        
        for(int i=0; i<n; i++){
            if(i >= k && nums[i - k] > 1){
                currentFlips--;
                nums[i - k] -= 2; 
            }
            
            if((nums[i] + currentFlips) % 2 == 0){
                if(i + k > n){
                    return -1;
                }
                
                currentFlips++;
                flips++;
                nums[i] += 2;
            }
        }
        
        return flips;
    }
}
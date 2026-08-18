class Solution {
    public boolean xorGame(int[] nums) {
        
        int totalXor = 0;
        
        for(int i=0; i<nums.length; i++){
            totalXor ^= nums[i];
        }
        
        if(totalXor == 0){
            return true;
        }
        
        return nums.length % 2 == 0;
    }
}
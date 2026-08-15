class Solution {
    public int longestSubsequence(int[] nums) {
        
        int totalXor = 0;
        boolean x = false;
        
        for(int i=0; i<nums.length; i++){
            totalXor ^= nums[i];
            if(nums[i] != 0){
                x = true;
            }
        }
        
        if(totalXor != 0){
            return nums.length;
        }
        
        if(x){
            return nums.length - 1;
        }
        
        return 0;
    }
}
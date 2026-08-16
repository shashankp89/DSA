class Solution {
    public int[] singleNumber(int[] nums) {
        
        int totalXor = 0;
        for(int i=0; i<nums.length; i++){
            totalXor ^= nums[i];
        }
         
        int diffBit = totalXor & (-totalXor);
        
        int A = 0;
        int B = 0;
        
        for(int i=0; i<nums.length; i++){
            if((nums[i] & diffBit) == 0){
                A ^= nums[i];
            } else {
                B ^= nums[i];
            }
        }
        
        return new int[]{A, B};
    }
}
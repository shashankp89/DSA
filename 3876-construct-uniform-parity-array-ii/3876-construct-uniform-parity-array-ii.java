class Solution {
    public boolean uniformArray(int[] nums) {

        int minodd=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                minodd=Math.min(minodd,nums[i]);
            }
        }
        if(minodd==Integer.MAX_VALUE){
            return true;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                if(nums[i]-minodd < 1){
                    return false;
                }
            }
            
        }
        return true;    
    }
}
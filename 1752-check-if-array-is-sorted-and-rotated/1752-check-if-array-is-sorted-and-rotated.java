class Solution {
    public boolean check(int[] nums) {
        int rot=0;
        int i=0;

        for(i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                rot++;
            }
            
        }
        if (rot>1){
            return false;
        }
        if (rot==1){
            if(nums[nums.length-1]>nums[0]){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
}
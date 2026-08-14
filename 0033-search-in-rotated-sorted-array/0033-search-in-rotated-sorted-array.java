class Solution {
    public int search(int[] nums, int target) {
        
        int st=0;
        int end=nums.length-1;

        while(st<=end){
            int mid= st+(end-st)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>=nums[st]){
                if(target>=nums[st] && target<nums[mid]){
                    end=mid-1;
                }else{
                    st=mid+1;
                }
            }else{
                if(target<=nums[end] && target>nums[mid]){
                    st=mid+1;
                }else{
                    end=mid-1;
                }
            }

        }
        return -1;
    }
}
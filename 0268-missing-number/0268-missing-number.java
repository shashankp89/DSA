class Solution {
    public int missingNumber(int[] nums) {

        int n=nums.length;
        int arrSum=0;

        for(int i=0;i<nums.length;i++){
            arrSum=arrSum+nums[i];

        }

        int rangeSum=n*(n+1)/2;

        return rangeSum-arrSum;
        
    }
}
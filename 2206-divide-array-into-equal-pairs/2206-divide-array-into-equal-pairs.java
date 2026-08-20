class Solution {
    public boolean divideArray(int[] nums) {
        
        // int xor=nums[0];

        // for(int i=1;i<nums.length;i++){
        //     xor ^=nums[i];
        // }

        // return xor==0;

        int [] temp = new int[501];

        for (int i=0;i<=500;i++){
            temp[i]=0;
        }

        for(int i=0;i<nums.length;i++){
            temp[nums[i]]+=1;
        }
        
        for(int i=1;i<=500;i++){
            if(temp[i]%2!=0){
                return false;
            }
        }
        return true;
    }
}
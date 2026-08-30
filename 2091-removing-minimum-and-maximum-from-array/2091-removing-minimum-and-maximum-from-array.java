class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;

        if(n==1){
            return 1;
        }
        int maxstep=0;
        int minstep=0;

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;


        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }

        for(int i=0;i<n;i++){
            if(nums[i]==max){
                maxstep=i;
            }
            if(nums[i]==min){
                minstep=i;
            }
        }
        
        int ans1= Math.max(maxstep,minstep)+1;
        int ans2= Math.max(n-maxstep,n-minstep);
        int ans3= 0;
        if(maxstep>minstep){
            ans3= n-maxstep + minstep+1;
        }else{
            ans3= n-minstep + maxstep+1;
        }

        return Math.min(ans1, Math.min(ans2,ans3));
        
    }
}
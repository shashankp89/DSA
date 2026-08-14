class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int k=0;

        int []positive= new int[n/2];
        int []negative= new int[n/2];

        for ( i=0; i<n;i++){
            if (nums[i]>0){
                positive[j]=nums[i];
                j++;
            }else{
                negative[k]=nums[i];
                k++;
            }
        }
        j=0;
        k=0;

        for (i=0;i<n;i++){
            if (i%2==0){
                nums[i]=positive[j];
                j++;
            }else{
                nums[i]=negative[k];
                k++;
            }
        }

        return nums;
        
    }
}
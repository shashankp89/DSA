class Solution {
    public void rotate(int[] nums, int k) {
        int i=0;
        int j=0;

        int n=nums.length;
        int newk= k%n;

        int []temp = new int[n];

        for (i=n-newk;i<n;i++){
            temp[j]=nums[i];
            j++;
        }

        for (i=0;i<n-newk;i++){
            temp[j]=nums[i];
            j++;
        }

        i=0;
        j=0;

        for (j=0;j<n;j++){
            nums[i]=temp[j];
            i++;
        }

        

        
    }
}
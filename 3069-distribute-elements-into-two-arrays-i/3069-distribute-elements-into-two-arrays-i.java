class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int [] result = new int[n];
        int [] temp = new int[n];
        int x=0;
        int y=n-1;

        temp[0]=nums[0];
        temp[n-1]=nums[1];

        for (int i=2;i<n;i++){
            if(temp[x]>temp[y]){
                temp[++x]=nums[i];
            }else{
                temp[--y]=nums[i];
            }
        }

        int i=0;
        while(i<=x){
            result[i]=temp[i];
            i++;
        }
        int k=n-1;
        while(k>x){
            result[i]=temp[k];
            k--;
            i++;
        }

        return result;
    }
}
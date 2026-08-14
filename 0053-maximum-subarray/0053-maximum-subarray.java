class Solution {
    public int maxSubArray(int[] a) {

        // int maxsum=a[0];
        // int ans=a[0];
        
        // for (int i=1;i<a.length;i++){
        //     int v1=maxsum+a[i];
        //     int v2=a[i];

        //     maxsum=Math.max(v1,v2);
        //     ans=Math.max(ans,maxsum);
        // }
        // return ans;
        

        int maxsum=a[0];
        int result=a[0];

        for(int i=1;i<a.length;i++){
            int v1=maxsum+a[i];
            int v2=a[i];

            maxsum=Math.max(v1,v2);
            result=Math.max(result,maxsum);
        }
        return result;
    }
}
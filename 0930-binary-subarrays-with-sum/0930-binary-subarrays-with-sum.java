class Solution {
    public int numSubarraysWithSum(int[] a, int g) {
        
        int n = a.length;
        int c = 0;
        
        for(int i = 0; i < n; i = i + 1){
            int s = 0;
            
            for(int j = i; j < n; j = j + 1){
                s = s + a[j];
                
                if(s == g){
                    c = c + 1;
                }
            }
        }
        
        return c;
    }
}
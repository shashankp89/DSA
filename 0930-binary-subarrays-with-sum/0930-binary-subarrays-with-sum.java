class Solution {
    public int numSubarraysWithSum(int[] a, int g) {
        
        return solve(a, g) - solve(a, g - 1);
    }
    
    private int solve(int[] a, int g){
        
        if(g < 0){
            return 0;
        }
        
        int l = 0;
        int s = 0;
        int c = 0;
        int n = a.length;
        
        for(int r = 0; r < n; r = r + 1){
            s = s + a[r];
            
            while(s > g){
                s = s - a[l];
                l = l + 1;
            }
            
            c = c + (r - l + 1);
        }
        
        return c;
    }
}
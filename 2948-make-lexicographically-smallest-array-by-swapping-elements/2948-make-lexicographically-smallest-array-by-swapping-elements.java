import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] a, int limit) {
        
        int n = a.length;
        long[] d = new long[n];
        
        for(int i = 0; i < n; i = i + 1){
            d[i] = ((long) a[i] << 32) | (long) i;
        }
        
        Arrays.sort(d);
        
        int[] ids = new int[n];
        int l = 0;
        
        while(l < n){
            int r = l + 1;
            
            while(r < n){
                long v1 = d[r] >> 32;
                long v2 = d[r - 1] >> 32;
                
                if(v1 - v2 <= limit){
                    r = r + 1;
                } else {
                    break;
                }
            }
            
            for(int i = l; i < r; i = i + 1){
                ids[i] = (int) d[i]; 
            }
            
            Arrays.sort(ids, l, r);
            
            for(int i = l; i < r; i = i + 1){
                a[ids[i]] = (int) (d[i] >> 32); 
            }
            
            l = r;
        }
        
        return a;
    }
}
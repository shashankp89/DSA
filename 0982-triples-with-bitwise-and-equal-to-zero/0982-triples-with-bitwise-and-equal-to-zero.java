class Solution {
    public int countTriplets(int[] a) {
        
        int n = a.length;
        int l = 1 << 16;
        int[] f = new int[l];
        
        for(int i = 0; i < n; i = i + 1){
            for(int j = 0; j < n; j = j + 1){
                int v = a[i] & a[j];
                f[v] = f[v] + 1;
            }
        }
        
        int c = 0;
        
        for(int i = 0; i < n; i = i + 1){
            for(int j = 0; j < l; j = j + 1){
                if((a[i] & j) == 0){
                    c = c + f[j];
                }
            }
        }
        
        return c;
    }
}
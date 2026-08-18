class Solution {
    public int getXORSum(int[] a, int[] b) {
        
        int n = a.length;
        int m = b.length;
        
        int x = 0;
        
        for(int i = 0; i < n; i = i + 1){
            x = x ^ a[i];
        }
        
        int y = 0;
        
        for(int i = 0; i < m; i = i + 1){
            y = y ^ b[i];
        }
        
        return x & y;
    }
}
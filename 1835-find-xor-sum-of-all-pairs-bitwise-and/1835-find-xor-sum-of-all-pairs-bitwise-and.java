class Solution {
    public int getXORSum(int[] a, int[] b) {
        
        int n = a.length;
        int m = b.length;
        int r = 0;
        
        for(int i = 0; i < 32; i = i + 1){
            int c1 = 0;
            
            for(int j = 0; j < n; j = j + 1){
                if(((a[j] >> i) & 1) == 1){
                    c1 = c1 + 1;
                }
            }
            
            int c2 = 0;
            
            for(int j = 0; j < m; j = j + 1){
                if(((b[j] >> i) & 1) == 1){
                    c2 = c2 + 1;
                }
            }
            
            if(c1 % 2 == 1){
                if(c2 % 2 == 1){
                    r = r | (1 << i);
                }
            }
        }
        
        return r;
    }
}
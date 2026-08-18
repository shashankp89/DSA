class Solution {
    public int[] countBits(int n) {
        
        int[] r = new int[n + 1];
        
        for(int i = 1; i <= n; i = i + 1){
            r[i] = r[i >> 1] + (i & 1);
        }
        
        return r;
    }
}
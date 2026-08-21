class Solution {
    public long findKthSmallest(int[] c, int k) {
        
        int n = c.length;
        int max = 1 << n;
        
        long[] lca = new long[max];
        int[] bca = new int[max];
        
        for(int i = 1; i < max; i = i + 1){
            long lc = 1;
            int b = 0;
            
            for(int j = 0; j < n; j = j + 1){
                if(((i >> j) & 1) == 1){
                    lc = getLcm(lc, c[j]);
                    b = b + 1;
                }
            }
            
            lca[i] = lc;
            bca[i] = b;
        }
        
        long lf = 1;
        long rt = (long) c[0] * k;
        long ans = 0;
        
        while(lf <= rt){
            long md = lf + (rt - lf) / 2;
            long tot = 0;
            
            for(int i = 1; i < max; i = i + 1){
                if(bca[i] % 2 == 1){
                    tot = tot + (md / lca[i]);
                } else {
                    tot = tot - (md / lca[i]);
                }
            }
            
            if(tot >= k){
                ans = md;
                rt = md - 1;
            } else {
                lf = md + 1;
            }
        }
        
        return ans;
    }
    
    private long getLcm(long a, long b){
        return (a * b) / getGcd(a, b);
    }
    
    private long getGcd(long a, long b){
        while(b > 0){
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
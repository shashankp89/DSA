class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
         
        int N = n + k - 1;
        int K = 2 * k;

        if (K > N) return 0;  

        long result = 1;
         
        for (int i = 1; i <= K; i++) {
            
            result = (result * (N - i + 1)) % MOD;
             
            result = (result * modInverse(i, MOD)) % MOD;
        }
        
        return (int) result;
    }
 
    private long modInverse(long a, int m) {
        return power(a, m - 2, m);
    }
 
    private long power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) { 
                res = (res * base) % mod;
            }
            exp = exp >> 1; 
            base = (base * base) % mod;  
        }
        return res;
    }
}
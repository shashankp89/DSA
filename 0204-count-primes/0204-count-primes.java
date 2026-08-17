class Solution {
    public int countPrimes(int n) {
        
        if (n <= 2) return 0;
 
        int count = n / 2;
         
        int[] composite = new int[(n >> 6) + 1];
        
        for (int i = 3; i * i < n; i += 2) {
             
            if ((composite[i >> 6] & (1 << ((i >> 1) & 31))) == 0) {
                
                for (int j = i * i; j < n; j += 2 * i) {
                     
                    if ((composite[j >> 6] & (1 << ((j >> 1) & 31))) == 0) {
 
                        composite[j >> 6] |= (1 << ((j >> 1) & 31));
                        count--;
                    }
                }
            }
        }
        
        return count;
    }
}
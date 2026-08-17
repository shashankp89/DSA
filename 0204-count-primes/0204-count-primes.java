class Solution {
    public int countPrimes(int n) {
        
        if(n <= 2) return 0;
         
        int count = n / 2;
        boolean[] isComposite = new boolean[n];
         
        for(int i = 3; i * i < n; i += 2) {
            
            if(!isComposite[i]) {
                 
                for(int j = i * i; j < n; j += 2 * i) {
                    
                    if(!isComposite[j]) {
                        isComposite[j] = true;
                        count--;  
                    }
                }
            }
        }
        
        return count;
    }
}
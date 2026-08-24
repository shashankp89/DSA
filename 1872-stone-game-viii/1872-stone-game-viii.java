class Solution {
    public int stoneGameVIII(int[] s) {
        
        int n = s.length;
        
        for(int i = 1; i < n; i = i + 1){
            s[i] = s[i] + s[i - 1];
        }
        
        int ans = s[n - 1];
        
        for(int i = n - 2; i > 0; i = i - 1){
            if(s[i] - ans > ans){
                ans = s[i] - ans;
            }
        }
        
        return ans;
    }
}
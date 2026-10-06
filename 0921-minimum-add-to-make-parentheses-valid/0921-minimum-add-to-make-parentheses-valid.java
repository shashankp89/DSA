class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            
            if (x == '(') {
                open++;
            } else {  
                if (open > 0) {
                    open--; 
                } else {
                    ans++; 
                }
            }
        }

        
        return ans + open;
    }
}
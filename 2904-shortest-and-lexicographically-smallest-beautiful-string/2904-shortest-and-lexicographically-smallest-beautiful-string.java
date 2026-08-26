class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int n = s.length();
        String ans = "";
        
        for(int i = 0; i < n; i = i + 1){
            for(int j = i + 1; j <= n; j = j + 1){
                String sub = s.substring(i, j);
                int c = 0;
                
                for(int x = 0; x < sub.length(); x = x + 1){
                    if(sub.charAt(x) == '1'){
                        c = c + 1;
                    }
                }
                
                if(c == k){
                    if(ans.equals("") == true || sub.length() < ans.length() || (sub.length() == ans.length() && sub.compareTo(ans) < 0)){
                        ans = sub;
                    }
                }
            }
        }
        
        return ans;
    }
}
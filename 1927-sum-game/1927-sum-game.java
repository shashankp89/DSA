class Solution {
    public boolean sumGame(String str) {
        
        int n = str.length();
        int s1 = 0;
        int s2 = 0;
        int q1 = 0;
        int q2 = 0;
        
        for(int i = 0; i < n / 2; i = i + 1){
            if(str.charAt(i) == '?'){
                q1 = q1 + 1;
            } else {
                s1 = s1 + (str.charAt(i) - '0');
            }
        }
        
        for(int i = n / 2; i < n; i = i + 1){
            if(str.charAt(i) == '?'){
                q2 = q2 + 1;
            } else {
                s2 = s2 + (str.charAt(i) - '0');
            }
        }
        
        if((q1 + q2) % 2 == 1){
            return true;
        }
        
        if(s1 - s2 == (q2 - q1) * 9 / 2){
            return false;
        }
        
        return true;
    }
}
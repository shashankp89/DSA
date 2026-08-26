class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int n = s.length();
        int l = 0;
        int c = 0;
        int bl = -1;
        int br = n;
        
        for(int r = 0; r < n; r = r + 1){
            if(s.charAt(r) == '1'){
                c = c + 1;
            }
            
            while(c > k || (l <= r && s.charAt(l) == '0')){
                if(s.charAt(l) == '1'){
                    c = c - 1;
                }
                l = l + 1;
            }
            
            if(c == k){
                int cl = r - l + 1;
                int blen = br - bl + 1;
                
                if(bl == -1 || cl < blen){
                    bl = l;
                    br = r;
                } else if(cl == blen){
                    boolean f = false;
                    
                    for(int i = 0; i < cl; i = i + 1){
                        if(s.charAt(l + i) < s.charAt(bl + i)){
                            f = true;
                            break;
                        } else if(s.charAt(l + i) > s.charAt(bl + i)){
                            break;
                        }
                    }
                    
                    if(f == true){
                        bl = l;
                        br = r;
                    }
                }
            }
        }
        
        if(bl == -1){
            return "";
        }
        
        return s.substring(bl, br + 1);
    }
}
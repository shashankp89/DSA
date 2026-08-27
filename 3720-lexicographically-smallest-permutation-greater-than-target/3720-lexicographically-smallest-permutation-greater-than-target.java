class Solution {
    public String lexGreaterPermutation(String s, String t) {
        
        int n = s.length();
        int[] c = new int[26];
        
        for(int i = 0; i < n; i = i + 1){
            int v = s.charAt(i) - 'a';
            c[v] = c[v] + 1;
        }
        
        int p = 0;
        
        while(p < n){
            int v = t.charAt(p) - 'a';
            
            if(c[v] > 0){
                c[v] = c[v] - 1;
                p = p + 1;
            } else {
                break;
            }
        }
        
        int i = p;
        
        if(i == n){
            i = i - 1;
            int v = t.charAt(i) - 'a';
            c[v] = c[v] + 1;
        }
        
        while(i >= 0){
            int b = -1;
            int v = t.charAt(i) - 'a';
            
            for(int j = v + 1; j < 26; j = j + 1){
                if(c[j] > 0){
                    b = j;
                    break;
                }
            }
            
            if(b != -1){
                char[] r = new char[n];
                
                for(int k = 0; k < i; k = k + 1){
                    r[k] = t.charAt(k);
                }
                
                r[i] = (char) (b + 'a');
                c[b] = c[b] - 1;
                
                int id = i + 1;
                
                for(int j = 0; j < 26; j = j + 1){
                    while(c[j] > 0){
                        r[id] = (char) (j + 'a');
                        c[j] = c[j] - 1;
                        id = id + 1;
                    }
                }
                
                return new String(r);
            }
            
            i = i - 1;
            
            if(i >= 0){
                int rv = t.charAt(i) - 'a';
                c[rv] = c[rv] + 1;
            }
        }
        
        return "";
    }
}
class Solution {
    public String lexPalindromicPermutation(String s, String t) {
        
        int n = s.length();
        int[] c = new int[26];
        
        for(int i = 0; i < n; i = i + 1){
            int v = s.charAt(i) - 'a';
            c[v] = c[v] + 1;
        }
        
        int oc = 0;
        int mc = -1;
        
        for(int i = 0; i < 26; i = i + 1){
            if(c[i] % 2 == 1){
                oc = oc + 1;
                mc = i;
            }
        }
        
        if(oc > 1){
            return "";
        }
        
        int[] hc = new int[26];
        for(int i = 0; i < 26; i = i + 1){
            hc[i] = c[i] / 2;
        }
        
        int len = n / 2;
        int p = 0;
        
        while(p < len){
            int v = t.charAt(p) - 'a';
            if(hc[v] > 0){
                hc[v] = hc[v] - 1;
                p = p + 1;
            } else {
                break;
            }
        }
        
        int i = p;
        
        if(i == len){
            char[] ex = new char[n];
            for(int k = 0; k < len; k = k + 1){
                ex[k] = t.charAt(k);
                ex[n - 1 - k] = t.charAt(k);
            }
            if(n % 2 == 1){
                ex[len] = (char) (mc + 'a');
            }
            
            String exs = new String(ex);
            if(exs.compareTo(t) > 0){
                return exs;
            }
            
            i = i - 1;
            
            // FIX: Added boundary check to prevent charAt(-1) on length 1 strings
            if(i >= 0){
                int v = t.charAt(i) - 'a';
                hc[v] = hc[v] + 1;
            }
        }
        
        while(i >= 0){
            int b = -1;
            int v = t.charAt(i) - 'a';
            
            for(int j = v + 1; j < 26; j = j + 1){
                if(hc[j] > 0){
                    b = j;
                    break;
                }
            }
            
            if(b != -1){
                char[] r = new char[n];
                
                for(int k = 0; k < i; k = k + 1){
                    r[k] = t.charAt(k);
                    r[n - 1 - k] = t.charAt(k);
                }
                
                r[i] = (char) (b + 'a');
                r[n - 1 - i] = (char) (b + 'a');
                hc[b] = hc[b] - 1;
                
                int id = i + 1;
                
                for(int j = 0; j < 26; j = j + 1){
                    while(hc[j] > 0){
                        r[id] = (char) (j + 'a');
                        r[n - 1 - id] = (char) (j + 'a');
                        hc[j] = hc[j] - 1;
                        id = id + 1;
                    }
                }
                
                if(n % 2 == 1){
                    r[len] = (char) (mc + 'a');
                }
                
                return new String(r);
            }
            
            i = i - 1;
            
            if(i >= 0){
                int rv = t.charAt(i) - 'a';
                hc[rv] = hc[rv] + 1;
            }
        }
        
        return "";
    }
}
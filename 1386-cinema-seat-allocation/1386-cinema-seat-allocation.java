import java.util.HashMap;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        
        HashMap<Integer, boolean[]> m = new HashMap<>();
        int l = rs.length;
        
        for(int i = 0; i < l; i = i + 1){
            int r = rs[i][0];
            int c = rs[i][1];
            
            if(m.containsKey(r) == false){
                m.put(r, new boolean[11]);
            }
            
            m.get(r)[c] = true;
        }
        
        int ans = (n - m.size()) * 2;
        
        for(int k : m.keySet()){
            boolean[] s = m.get(k);
            
            boolean lf = s[2] == false && s[3] == false && s[4] == false && s[5] == false;
            boolean rt = s[6] == false && s[7] == false && s[8] == false && s[9] == false;
            boolean md = s[4] == false && s[5] == false && s[6] == false && s[7] == false;
            
            if(lf == true && rt == true){
                ans = ans + 2;
            } else if(lf == true){
                ans = ans + 1;
            } else if(rt == true){
                ans = ans + 1;
            } else if(md == true){
                ans = ans + 1;
            }
        }
        
        return ans;
    }
}
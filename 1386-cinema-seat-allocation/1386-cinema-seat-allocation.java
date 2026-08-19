import java.util.HashMap;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        
        HashMap<Integer, Integer> m = new HashMap<>();
        int l = rs.length;
        
        for(int i = 0; i < l; i = i + 1){
            int r = rs[i][0];
            int c = rs[i][1];
            
            if(m.containsKey(r) == true){
                m.put(r, m.get(r) | (1 << c));
            } else {
                m.put(r, 1 << c);
            }
        }
        
        int ans = (n - m.size()) * 2;
        
        for(int k : m.keySet()){
            int v = m.get(k);
            
            boolean lf = (v & 60) == 0;
            boolean rt = (v & 960) == 0;
            boolean md = (v & 240) == 0;
            
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
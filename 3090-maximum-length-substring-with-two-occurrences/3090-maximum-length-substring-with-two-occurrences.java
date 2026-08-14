class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            Character x = s.charAt(r);
             
            map.put(x, map.getOrDefault(x, 0) + 1);
 
            while (map.get(x) > 2) {
                Character y = s.charAt(l);
                map.put(y, map.get(y) - 1);
                l++;
            }
 
            ans = Math.max(ans, (r - l + 1));
            
            r++;
        }
        
        return ans;
    }
}
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < n; i++) {
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        
        List<String> result = new ArrayList<>();
        int right = -1;
        
        for (int i = 0; i < n; i++) {
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = getRightBound(s, i, first, last);
                if (newRight != -1) {
                    if (i > right) {
                        result.add("");
                    }
                    right = newRight;
                    result.set(result.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        
        return result;
    }
    
    private int getRightBound(String s, int i, int[] first, int[] last) {
        int right = last[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (first[c] < i) {
                return -1;
            }
            right = Math.max(right, last[c]);
        }
        return right;
    }
}
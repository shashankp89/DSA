class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;
        
        int min_c = 0;
        int max_c = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(min_c)) {
                min_c = i;
            }
            if (s.charAt(i) >= s.charAt(max_c)) {
                max_c = i;
            }
        }
        
        if (min_c == 0 || max_c == n - 1) {
            return 1;
        }
        
        if (min_c == n - 1 && max_c == 0) {
            return 3;
        }
        
        return 2;
    }
}
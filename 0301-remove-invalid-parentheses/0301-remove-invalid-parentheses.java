import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int leftRem = 0;
        int rightRem = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRem++;
            } else if (s.charAt(i) == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }
        
        dfs(s, 0, leftRem, rightRem, res);
        return res;
    }
    
    private void dfs(String s, int start, int leftRem, int rightRem, List<String> res) {
        if (leftRem == 0 && rightRem == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (leftRem > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftRem - 1, rightRem, res);
            }
            if (rightRem > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftRem, rightRem - 1, res);
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
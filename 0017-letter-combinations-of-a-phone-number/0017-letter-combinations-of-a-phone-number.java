import java.util.ArrayList;
import java.util.List;

class Solution {

    public void temp(String digits, int idx, String[] map, StringBuilder current, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(current.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            temp(digits, idx + 1, map, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        temp(digits, 0, map, new StringBuilder(), ans);
        
        return ans;
    }
}
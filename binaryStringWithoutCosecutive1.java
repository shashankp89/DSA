/*Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.



A binary string is a string consisting only of characters '0' and '1'.


Example 1

Input: n = 3

Output: ["000", "001", "010", "100", "101"]

Explanation: All strings are of length 3 and do not contain consecutive 1s.

Example 2

Input: n = 2

Output: ["00", "01", "10"]

Constraints

1 <= n <= 20*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public void temp(int n, int idx, char[] s, List<String> ans) {
        if (idx == n) {
            ans.add(new String(s));
            return;
        }

        temp(n, idx + 1, s, ans);

        if (idx == 0 || s[idx - 1] != '1') {
            s[idx] = '1';
            temp(n, idx + 1, s, ans);
            s[idx] = '0';
        }
    }

    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        
        char[] s = "0".repeat(n).toCharArray(); 
        int idx = 0; 
        temp(n, idx, s, ans);

        return ans;
    }
}
import java.util.*;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                stack.push(i);
                result[i] = stack.size() % 2;
            } else {
                result[i] = stack.size() % 2;
                stack.pop();
            }
        }

        return result;
    }
}
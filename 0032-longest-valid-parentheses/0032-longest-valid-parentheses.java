class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
 
        int[] stack = new int[s.length() + 1];
        int top = -1;
 
        stack[++top] = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                 
                stack[++top] = i;
            } else {
                 
                top--;

                if (top == -1) {
                    
                    stack[++top] = i;
                } else {
                     
                    int len = i - stack[top];
                    if (len > max) {
                        max = len;
                    }
                }
            }
        }

        return max;
    }
}

class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(') {
                count++;
                ans=Math.max(ans,count);
            }
            if (ch == ')') {
                count--;
                 
            }

        }
        return ans;
    }
}
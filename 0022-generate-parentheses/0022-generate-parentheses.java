class Solution {
    public void temp(int n, int open, int close, StringBuilder sb, List<String> ans){
        if(open==n && close==n){
            ans.add(sb.toString());
            return ;
        }
        if(open<n){
            sb.append("(");
            temp(n, open+1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(")");
            temp(n, open, close+1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        int open=0;
        int close=0;

        StringBuilder sb = new StringBuilder(""); 
        temp(n, open, close, sb, ans);

        return ans;
        
    }
}
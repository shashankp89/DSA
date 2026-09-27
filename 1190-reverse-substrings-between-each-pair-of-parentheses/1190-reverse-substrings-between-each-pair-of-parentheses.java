class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.indexOf("(") != -1) {
            int start = sb.lastIndexOf("(");
            int end = sb.indexOf(")", start);
            
            StringBuilder temp = new StringBuilder(sb.substring(start + 1, end));
            temp.reverse();
            
            sb.replace(start, end + 1, temp.toString());
        }
        
        return sb.toString();
    }
}
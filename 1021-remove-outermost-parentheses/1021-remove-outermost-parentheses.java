class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int st=0;
        int end=1;
        int count=1;

        while(end<s.length()){
            Character ch = s.charAt(end);
            if(ch=='('){
                count++;
            }else{
                count--;
            }

            if(count==0){
                st++;
                while(st<end){
                    sb.append(s.charAt(st));
                    st++;
                }
                st++;
            }
            end++;
        }
        return sb.toString();
    }
}
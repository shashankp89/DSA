class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                st.push(x);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (x == ')') {
                    if (st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
                if (x == '}') {
                    if (st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
                if (x == ']') {
                    if (st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}
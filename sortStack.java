class Solution {
    public void insert(int a, Stack<Integer> st){

        if(st.empty()|| st.peek()<a){
            st.push(a);
            return;
        }

        int b=st.pop();
        insert(a,st);
        st.push(b);
        return;
    }
    public void sortStack(Stack<Integer> st) {

        if(st.empty()){
            return;
        }

        int a=st.pop();
        sortStack(st);
        insert(a,st);
        return;    
    }
}
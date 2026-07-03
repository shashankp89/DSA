/*You are given a stack of integers. Your task is to reverse the stack using recursion. You may only use standard stack operations (push, pop, top/peek, isEmpty). You are not allowed to use any loop constructs or additional data structures like arrays or queues.



Your solution must modify the input stack in-place to reverse the order of its elements.


Example 1

Input: stack = [4, 1, 3, 2]

Output: [2, 3, 1, 4]

Example 2

Input: stack = [10, 20, -5, 7, 15]

Output: [15, 7, -5, 20, 10]

Constraints

1 <= N <= 100 (where N is the number of elements in the stack)
Must use only recursion (no loops or built-in reverse methods)
Auxiliary space allowed: O(N) (due to recursion stack) */


import java.util.Stack;
class Solution {
    public void insert(Stack<Integer> st, int a){
        if(st.empty()){
            st.push(a);
            return;
        }
        int b=st.pop();
        insert(st,a);
        st.push(b);
        return;
    }
    public void reverseStack(Stack<Integer> st) {
        if (st.empty()){
            return;
        }
        int a=st.pop();
        reverseStack(st);
        insert(st,a);
        return;
    }
}
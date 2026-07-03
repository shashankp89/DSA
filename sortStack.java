/*You are given a stack of integers. Your task is to sort the stack in descending order using recursion, such that the top of the stack contains the greatest element. You are not allowed to use any loop-based sorting methods (e.g., quicksort, mergesort). You may only use recursive operations and the standard stack operations (push, pop, peek/top, and isEmpty).


Example 1

Input: stack = [4, 1, 3, 2]

Output: [4, 3, 2, 1]

Explanation:

After sorting, the largest element (4) is at the top, and the smallest (1) is at the bottom.



Example 2

Input: stack = [1]

Output: [1]

Explanation:

A single-element stack is already sorted.



Constraints

1 <= N <= 100 (where N is the number of elements in the stack)
Use recursion to implement the sorting logic.
You may use auxiliary space up to O(N) (call stack).



*/
import java.util.Stack;
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
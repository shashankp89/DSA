/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = new int[2];

        int min = Integer.MAX_VALUE;
        
        int max = 0;

        if (head.next.next == null) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        ListNode back = head;
        ListNode curr = head.next;
        ListNode front = head.next.next;

        int count = 0;
        int st = 0;

        while (front != null) {
            if ((curr.val > front.val && curr.val > back.val) || (curr.val < front.val && curr.val < back.val)) {
                if (st == 0) {
                    st = 1;
                    count = 0;
                } else {
                    min = Math.min(min, count);
                    max += count;
                    count = 0;
                }

            }
            count++;
            front = front.next;
            curr = curr.next;
            back = back.next;
        }

        if(max==0){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }

        ans[0] = min;
        ans[1] = max;

        return ans;

    }
}
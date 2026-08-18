/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next = node.next;

        while (curr != null) {
            if (curr.next.next == null) {
                curr.val = curr.next.val;
                curr.next = null;
                return;
            } else {
                curr.val = curr.next.val;
                curr = curr.next;
            }
        }

    }
}
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
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;
        HashSet<Integer> s = new HashSet<>();
        int count = 0;
        int connected = 0;

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        while (temp != null) {
            if (!s.contains(temp.val)) {
                if (connected != 0) {
                    count++;
                    connected = 0;
                }

            } else {
                connected++;
            }
            temp = temp.next;
        }

        if (connected != 0) {
            count++;
        }

        return count;

    }
}
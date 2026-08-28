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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode temp = head.next;
        ListNode point = head;
        int sum=0;

        while(temp!=null){
            if(temp.val==0){
                point.val=sum;
                if(temp.next==null){
                    point.next=null;
                }else{
                    point.next=temp;
                }
                point=point.next;
                sum=0;
            }
            sum+=temp.val;
            temp=temp.next;
        }

        return head;
    }
}
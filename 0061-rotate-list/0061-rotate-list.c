/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(head==NULL || head->next==NULL){
        return head;
    }
    struct ListNode* temp1 = head;
    struct ListNode* temp2 = head;
    int n=1;

    while (temp1->next!=NULL){
        n++;
        temp1=temp1->next;
    }

    int newk= k%n;
    
    for (int i=1;i<n-newk;i++){
        temp2=temp2->next;
    }
    
    temp1->next=head;
    head=temp2->next;
    temp2->next=NULL;

     

    return head;
}
    

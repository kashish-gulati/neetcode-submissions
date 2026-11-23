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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var temp = head;
        for(int i=0;i<n;i++) {
            temp=temp.next;
        }
        // temp=temp.next;
        ListNode t2 = head,t2r=null;
        while(temp!=null) {
            temp=temp.next;
            t2r=t2;
            t2=t2.next;
        }
        if(t2==head) return head.next;
        if(t2!=null && t2r!=null) t2r.next=t2.next;
        else if(t2!=null) return t2r;
        return head;
    }
}

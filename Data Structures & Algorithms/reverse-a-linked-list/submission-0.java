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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        while(temp!=null && temp.next!=null) temp=temp.next;
        reverseAndAppendHead(head);
        return temp;
    }

    public ListNode reverseAndAppendHead(ListNode head) {
        if(head!=null) {
            ListNode tail = reverseAndAppendHead(head.next);
            head.next=null;
            if(tail!=null) tail.next=head;
        }
        return head;
    }
}

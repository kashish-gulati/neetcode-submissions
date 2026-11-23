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
    public void reorderList(ListNode head) {
        //find length/2(floor) lets say 2 for 5
        int len=0;
        var temp = head;
        while(temp!=null) {
            len++;
            temp=temp.next;
        }
        int stsize = len/2;
        //iterate to length/2(ceil)+1 lets say 3rd+1/5
        temp = head;
        for(int i=0;i<(len-stsize);i++) {
            temp=temp.next;
        }
        // if(temp!=null) temp=temp.next;
        //start adding to stack
        Stack<ListNode> eStack = new Stack<>();
        while(temp!=null) {
            eStack.push(temp);
            temp=temp.next;
        }
        //iterate from start, adding atack elem after every current elem.
        temp = head;
        while(!eStack.isEmpty()) {
            var e = eStack.pop();
            e.next=temp.next;
            temp.next=e;
            temp=e.next;
        }
        if(temp!=null) temp.next=null;
        // return head;
    }
}

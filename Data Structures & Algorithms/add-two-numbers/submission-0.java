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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        if(l1==null && l2==null) {
            return carry!=0?new ListNode(carry):null;
        } else if(l1==null) {
            int nCarry=(carry+l2.val)/10;
            return new ListNode((carry+l2.val)%10,add(l1,l2.next,nCarry));
        } else if(l2==null) {
            int nCarry=(carry+l1.val)/10;
            return new ListNode((carry+l1.val)%10,add(l1.next,l2,nCarry));
        } else {
            int nCarry=(carry+l1.val+l2.val)/10;
            return new ListNode((carry+l1.val+l2.val)%10,add(l1.next,l2.next,nCarry));
        }
    }
}

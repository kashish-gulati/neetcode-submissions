/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node h2 = new Node(head.val);
        Map<Node,Node> nMap = new HashMap<>();
        nMap.put(head, h2);
        var t2 = h2;
        var t1 = head.next;
        //copy only nexts
        while(t1!=null) {
            t2.next = new Node(t1.val);
            t2=t2.next;
            nMap.put(t1,t2);
            t1=t1.next;
        }

        //link rands to existing nodes
        t2 = h2;
        t1 = head;
        while(t2!=null) {
            if(t1.random!=null){
                t2.random = nMap.get(t1.random);
            }
            t1=t1.next;
            t2=t2.next;
        }

        return h2;
    }

}

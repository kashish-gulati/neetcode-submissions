class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PQ pq = new PQ();
        for(int i=0;i<k;i++) {
            // System.out.println("adding "+i+" val "+ nums[i]);
            pq.addEl(nums[i]);
        }
        res[0]=pq.max();

        for(int i=k;i<nums.length;i++) {
            // System.out.println("adding "+i+" val "+ nums[i]);
            pq.addEl(nums[i]);
            // System.out.println("removing "+(i-k)+" val "+ nums[i-k]);
            pq.removeEl(nums[i-k]);
            res[i-k+1]=pq.max();
        }
        return res;
    }


    class PQ {
        class Node {
            public Node(int val, Node prev, Node next) {
                this.val=val;
                this.next=next;
                this.prev=prev;
                count=1;
            }
            public int val;
            public int count;
            public Node prev;
            public Node next;
        }
        Node head;
        Map<Integer,Node> nodeMap;
        public PQ() {
            head=null;
            nodeMap=new HashMap<>();
        }
        public void addEl(int val) {
            if(head==null) {
                Node node = new Node(val,null,null);
                head = node;
                nodeMap.put(val,node);
            } else {
                //todo
                Node itr = head;
                while(itr!=null) {
                    if(itr.val<val) {
                        Node node = new Node(val,itr.prev,itr);
                        nodeMap.put(val,node);
                        if(itr.prev!=null) itr.prev.next=node;
                        itr.prev=node;
                        break;
                    } else if(itr.val==val) {
                        itr.count++;
                        break;
                    } else {
                        if(itr.next!=null) {
                            itr=itr.next;
                        } else {
                            itr.next = new Node(val,itr,null);
                            nodeMap.put(val,itr.next);
                            break;
                        }
                    }
                }
                if(head.prev!=null) head=head.prev;
                //head greater
                //head less
                //head equal
                //iterate node->next<val
            }
        }
        public void removeEl(int val) {
            Node n = nodeMap.get(val);
            n.count--;
            // System.out.println("val "+ val + " to count "+ n.count);
            if(n.count==0) {
                if(n==head) head=head.next;
                if(n.prev!=null) n.prev.next=n.next;
                if(n.next!=null) n.next.prev=n.prev;
            }
        }
        public int max() {
            return head.val;
        }
    }
}

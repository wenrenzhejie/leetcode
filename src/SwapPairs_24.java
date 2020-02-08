public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode next = null;
        while (node2 != null){
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;

            pre = node1;
            node1 = node1.next;
            if (node1 == null){
                break;
            }
            node2 = node1.next;
        }
        return dummyHead.next;
    }
}

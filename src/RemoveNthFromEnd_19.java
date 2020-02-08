public class RemoveNthFromEnd_19 {
    //使用双指针巧妙解决删除从后往前数第k个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = pre;
        for (int i = 0;i <= n;i ++){
           end = end.next;
        }
        while (end != null){
            end = end.next;
            pre = pre.next;
        }
        ListNode temp = pre.next.next;
        pre.next.next = null;
        pre.next = null;
        pre.next = temp;
        return dummyHead.next;
    }
}

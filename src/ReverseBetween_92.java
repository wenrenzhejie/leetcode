import javax.print.MultiDoc;

public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n){
            return head;
        }
        ListNode first = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        ListNode mNode = null;
        int i = 0;
        while (i < n && current != null){
            if (i < m - 2){
                current = current.next;
            }else if (i == m - 2){
                first = current;
                current = current.next;
            }else if (i == m - 1){
                mNode = current;
                pre = current;
                current = current.next;
            }else {
                next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            i ++;
        }
        if (mNode != null){
            mNode.next = current;
        }
        if (first != null){
            first.next = pre;
            return head;
        }else {
            return pre;
        }
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 1;i < 2;i ++){
            node.next = new ListNode(i + 1);
            node = node.next;
        }
        ListNode listNode = new ReverseBetween_92().reverseBetween(head,1,2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

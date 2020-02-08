import java.util.Currency;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null){
            int val = current.val;
            if (pre.val == val){
                pre.next = current.next;
            }else {
                pre = current;
            }
            current = current.next;
        }
        return head;
    }
}

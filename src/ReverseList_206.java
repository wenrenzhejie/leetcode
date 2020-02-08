import jdk.nashorn.internal.objects.NativeUint8Array;

public class ReverseList_206 {
    private ListNode n;
    public ListNode reverseList(ListNode head) {
        ListNode reverse = reverse(head);
        if (reverse == null){
            return null;
        }else {
            reverse.next = null;
        }
        return n;
    }
    private ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }
        ListNode reverse = reverse(node.next);
        if (reverse != null){
            reverse.next = node;
        }else {
            this.n = node;
        }
        return node;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 1;i < 5;i ++){
            node.next = new ListNode(i + 1);
            node = node.next;
        }
        ListNode listNode = new ReverseList_206().reverseList(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

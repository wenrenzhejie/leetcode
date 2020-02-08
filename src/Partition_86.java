public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode lowerNode = null;
        ListNode current = head;
        ListNode pre = null;
        while (current != null){
            if (current.val < x){
                if (lowerNode == null){
                    if (pre != null){
                        pre.next = current.next;
                        current.next = head;
                        head = current;
                        lowerNode = current;
                        current = pre.next;
                    }else {
                        lowerNode = current;
                        pre = current;
                        current = current.next;
                    }
                }else {
                    if (lowerNode == pre){
                        lowerNode = current;
                        pre = lowerNode;
                        current = current.next;
                    }else {
                        pre.next = current.next;
                        current.next = lowerNode.next;
                        lowerNode.next = current;
                        lowerNode = lowerNode.next;
                        current = pre.next;
                    }

                }
            }else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }
    //这道题可以使用双指针
    public static void main(String[] args){
        int[] arr = new int[]{1,1};
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1;i < arr.length;i ++){
           node.next = new ListNode(arr[i]);
           node = node.next;
        }
        new Partition_86().partition(head,3);
    }
}

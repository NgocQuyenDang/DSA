package LinkedList;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }

        if (size == 1) {
            head = head.next;
            return head;
        }

        ListNode previousNode = head;
        if (size > 1) {
            int middlePosition = size / 2;
            for (int i = 0; i < middlePosition - 1; i++) {
                previousNode = previousNode.next;
            }
            previousNode.next = previousNode.next.next;
        }
        return head;
    }
}

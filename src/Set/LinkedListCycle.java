package Set;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while(cur != null){
            if(set.contains(cur)){
                return true;
            } else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}

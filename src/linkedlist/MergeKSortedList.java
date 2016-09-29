package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.data - l2.data;
            }
        };

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(comp);

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            current.next = n;
            current = current.next;

            if (n.next != null) {
                queue.offer(n.next);
            }
        }

        return head.next;
    }

}

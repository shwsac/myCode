package linkedlist;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 0 || k == 1) {
            return head;
        }
        ListNode current = head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;

        int i = 0;
        while (current != null) {
            i++;
            ListNode next = null;
            if (i % k == 0) {
                next = current.next;
                prev = reverse(prev, next);
                current = prev.next;
            } else {
                current = current.next;
            }
        }
        return fake.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode current = start.next;
        ListNode prev = start;
        ListNode next = null;

        while (current != end) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode last = start.next;
        last.next = end;
        start.next = prev;
        return last;
    }

}

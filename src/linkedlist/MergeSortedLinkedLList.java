package linkedlist;

public class MergeSortedLinkedLList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode newhead = new ListNode(0);
        ListNode current = newhead;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.data < l2.data) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            else if (l1 != null) {
                current.next = l1;
                break;
            } else if (l2 != null) {
                current.next = l2;
                break;
            }
        }
        return newhead.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

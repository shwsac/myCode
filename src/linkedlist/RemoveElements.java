package linkedlist;

public class RemoveElements {
    
    public static ListNode removeElements(ListNode head, int data) {
        if(head == null) {
            return null;
        }
        ListNode current = head; 
        while(current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head.data == data ? head.next:head;
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head; 
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        ListNode head = obj.createLinkedListFive();
        RemoveElements.removeElements(head,5);
        obj.displayList();
    }
}

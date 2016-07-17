package linkedlist;
public class OddEvenLinkedList {
   

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCurrent = head;
        ListNode evenCurrent = head.next;
        
        while(evenCurrent!=null && evenCurrent.next!=null) {
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }
        
        oddCurrent.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.insertNode(1);
        obj.insertNode(2);
        obj.insertNode(3);
        obj.insertNode(4);
        ListNode newHead = oddEvenList(obj.head);
        obj.displayList();

    }

}

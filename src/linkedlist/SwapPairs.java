package linkedlist;

public class SwapPairs {
    
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode newhead =head.next;
        ListNode current = newhead;
        ListNode prev = head;
        ListNode temp = current.next;
        
        while(temp !=null && temp.next != null) {
           
            current.next = prev;
            current = temp.next;
            prev.next = current;
            prev = temp;
            temp = current.next;
        }
        
        current.next = prev;
        prev.next = temp;
        return newhead;
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

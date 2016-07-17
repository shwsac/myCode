package linkedlist;

public class RotateList {
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) {
            return head;
        }
        
        ListNode current = head;
        int length = 1;
        while(current.next!= null) {
            current = current.next;
            length++;
        }
        
        k = k % length;
        ListNode second = head;
        
        for(int i = 1; i < length - k; i++) {
           second = second.next; 
        }
        
        current.next = head;
        head = second.next;
        second.next = null;
        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

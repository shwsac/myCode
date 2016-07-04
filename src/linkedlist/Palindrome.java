package linkedlist;

import java.util.Stack;

public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        if(head == null  || head.next == null) {
            return true;
        }
        Stack<ListNode> stk = new Stack<ListNode>();
        stk.push(head);
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stk.push(slow);
        }
        if(fast.next == null) {
            stk.pop();
        }
        while(!stk.isEmpty()){
            if(stk.pop().data != slow.next.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    //Without using extra memory
    public boolean isPalindrome2(ListNode head) {
        if(head == null  || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        
        while (p1!=null && p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2= temp;
        }
        
        secondHead.next = null;
        
        ListNode p = (p2==null?p1:p2);
        ListNode q = head;
        while(p!=null) {
            if(p.data != q.data) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}

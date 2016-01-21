package linkedlist;
class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    ListNode head;

    LinkedList() {
        head = null;
    }

    LinkedList(int n) {
        head = new ListNode(n);
    }

    public void insertNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertNode(ListNode n) {
        if (head == null) {
            head = n;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }

    public ListNode deleteNode(ListNode n) {
        ListNode current = head;
        if (current == n) {
            return head.next;
        }
        while (current.next != null) {
            if (current.next == n) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public void displayList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
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

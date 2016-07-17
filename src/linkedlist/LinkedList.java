package linkedlist;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        next = null;
    }

}
public class LinkedList {
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
    
    public ListNode createLinkedListFive() {
       
        insertNode(1);
        insertNode(2);
        insertNode(3);
        insertNode(4);
        insertNode(5);
        return head;
        
    }
}

package linkedlist;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedListNode {
    Node head;

    LinkedListNode() {
        head = null;
    }

    LinkedListNode(int n) {
        head = new Node(n);
    }

    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertNode(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }

    public Node deleteNode(Node n) {
        Node current = head;
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
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class SwapTwoLinks {

    static Node swapTwoPositions(Node head, int x, int y) {
        if (head == null) {
            return null;
        }
        if (x == y) {
            return head;
        }
        Node prevX = null;
        Node prevY = null;
        Node currentX = head;
        Node currentY = head;
        
        while (currentX != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;
        }
        while (currentY != null && currentY.data != y) {
            prevY = currentY;
            currentY = currentY.next;
        }
        if (currentX == null || currentY == null) {
            return null;
        }

        if (currentX != head) {
            prevX.next = currentY;
        } else {
            head = currentY;
        }

        if (currentY != head) {
            prevY.next = currentX;
        } else {
            head = currentX;
        }

        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
        return head;
    }


    public static void main(String[] args) {
        LinkedListNode obj = new LinkedListNode();
        obj.insertNode(3);
        obj.insertNode(1);
        obj.insertNode(5);
        obj.insertNode(9);
        obj.displayList();
        Node newHead = swapTwoPositions(obj.head,1,9);
       
        Node current = newHead;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }  
        System.out.println();
    }
}

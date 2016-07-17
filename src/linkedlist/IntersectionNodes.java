package linkedlist;
class LinkedListInfo {
    int length;
    ListNode lastNode;
    
    LinkedListInfo() {
        length = 1;
        lastNode = null;
    }
} 
public class IntersectionNodes {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        LinkedListInfo infoA = getLastNode(headA);
        LinkedListInfo infoB = getLastNode(headB);
        if (infoA.lastNode != infoB.lastNode) {
            return null;
        }
        int diff = (int) Math.abs(infoA.length - infoB.length);
        ListNode currentA = headA;
        ListNode currentB = headB;
        if (infoA.length > infoB.length) {
            for (int i = 0; i < diff; i++) {
                currentA = currentA.next;
            }
        } else if (infoA.length < infoB.length) {
            for (int i = 0; i < diff; i++) {
                currentB = currentB.next;
            }
        }
        while (currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
            ;
        }
        return currentA;

    }

    private LinkedListInfo getLastNode(ListNode node) {
        LinkedListInfo info = new LinkedListInfo();
        while (node.next != null) {
            node = node.next;
            info.length = info.length + 1;
        }
        info.lastNode = node;
        return info;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

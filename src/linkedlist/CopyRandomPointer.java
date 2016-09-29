package linkedlist;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
 };

public class CopyRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> hMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode current = head;
        RandomListNode newHead = null;
        RandomListNode newCurrent = null;
        while (current != null) {
            if (!hMap.containsKey(current)) {
                RandomListNode temp = new RandomListNode(current.label);
                if (newHead == null) {
                    newHead = temp;
                    newCurrent = newHead;
                } else {
                    newCurrent.next = temp;
                    newCurrent = newCurrent.next;
                }
                hMap.put(current, temp);
            }
            current = current.next;
        }
        newCurrent.next = null;

        for (Map.Entry<RandomListNode, RandomListNode> entry : hMap.entrySet()) {
            RandomListNode key = entry.getKey();
            RandomListNode randomNode = hMap.get(key.random);
            entry.getValue().random = randomNode;
        }

        return newHead;
    }

}

package leetcodepremium;

import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> hMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        hMap = new HashMap<Integer, Node>();
        head = null;
        tail = null;

    }

    public void moveToHead(Node n) {

        if (n == head) {
            return;
        }
        Node temp = n;
        if (n == tail) {
            n.prev.next = null;
            tail = n.prev;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        temp.next = head;
        temp.prev = null;
        head.prev = temp;
        head = temp;

    }

    public void insertToHead(Node n) {

        tail.prev.next = null;
        tail = tail.prev;

        n.next = head;
        head.prev = n;
        head = n;
        n.prev = null;
    }

    public int get(int key) {
        //
        if (!hMap.containsKey(key)) {
            return -1;
        }
        Node n = hMap.get(key);

        moveToHead(n);
        return n.val;

    }

    public void set(int key, int value) {

        if (hMap.containsKey(key)) {
            Node node = hMap.get(key);
            moveToHead(node);
            head.val = value;
            hMap.put(key, head);
        } else {
            Node newNode = new Node(key, value);
            if (hMap.size() < capacity) {
                hMap.put(key, newNode);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                    return;
                }

                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                Node temp = tail;
                if (head == tail) {
                    head = newNode;
                    tail = newNode;
                } else {
                    insertToHead(newNode);
                }
                hMap.remove(temp.key);
                hMap.put(key, newNode);
            }
        }

    }
}
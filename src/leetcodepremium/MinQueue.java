package leetcodepremium;

import java.util.Comparator;
import java.util.LinkedList;


public class MinQueue<K extends Comparable> {
    
    LinkedList<K> queue = new LinkedList<>();
    LinkedList<K> minQueue = new LinkedList<>();
    
    MinQueue() {
    }
    
    public void add(K val) {
        queue.add(val);        
        while(!minQueue.isEmpty() && val.compareTo(minQueue.peekLast()) < 0) {
            minQueue.removeLast();
        }
        minQueue.add(val);
    }
    
    public K remove() {
        if(queue.isEmpty()) {
            return null;
        }
        K item = queue.remove();
        if(item == minQueue.peekFirst()) {
            minQueue.remove();
        }
        return item;
    }
    
    public K getMin(){
        return minQueue.peek();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinQueue<Integer> obj = new MinQueue<Integer>();
        obj.add(3);
        obj.add(6);
        //obj.add(2);
        System.out.println(obj.getMin());

    }

}

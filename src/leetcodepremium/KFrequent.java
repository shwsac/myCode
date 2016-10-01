package leetcodepremium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class KFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<Integer>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        HashMap<Integer, Pair> hMap = new HashMap<Integer, Pair>();
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {

            @Override
            public int compare(Pair a, Pair b) {
                return a.count - b.count;
            }

        });

        for (Integer n : nums) {
            Pair newNum;
            if (hMap.containsKey(n)) {
                newNum = hMap.get(n);
                newNum.count++;
            } else {
                newNum = new Pair(n, 1);
                hMap.put(n, newNum);

            }

            if (!newNum.inTop) { // when not in top queue
                if (queue.size() < k) {
                    queue.add(newNum);
                    newNum.inTop = true;
                } else if (queue.peek().count < newNum.count) {
                    queue.offer(newNum);
                    newNum.inTop = true;
                    queue.remove().inTop = false;
                }
            } else {
                queue.add(queue.poll()); // heapify
            }
//            System.out.println("From inside for number: " + newNum.val);
//            for (Pair p : queue) {
//                System.out.print("( val- " + p.val + ": count- " + p.count + ")");
//            }
//            System.out.println();

        }

        while (queue.size() > 0) {
            result.add(queue.poll().val);
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 1, 5, 6, 6, 6, 6, 1, 2, 3, 1, 2, 4, 6, 1 };
        System.out.println(topKFrequent(input, 3));

    }
}

class Pair {
    int val;
    int count;
    boolean inTop;

    Pair(int val, int count) {
        this.val = val;
        this.count = count;
        inTop = false;
    }

}

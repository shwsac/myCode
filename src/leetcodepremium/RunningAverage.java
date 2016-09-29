package leetcodepremium;

import java.util.LinkedList;

public class RunningAverage {
    
    LinkedList<Integer> queue;
    double avg;
    int size;
    
    RunningAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(queue.size() < this.size) {
            queue.offer(val);
            int sum = 0;
            for(int i : queue) {
                sum += i;
            }
            avg = (double)sum/queue.size();
            return avg;
        } 
        else {
            int head = queue.poll();
            double minus = (double)head/queue.size();
            queue.offer(val);
            double add = (double)val/queue.size();
            avg = avg + add - minus;
            return avg;
        }
    }

}

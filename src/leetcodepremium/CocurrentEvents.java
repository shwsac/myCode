package leetcodepremium;

import java.util.Comparator;

class Interval {
        public int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
}
class MyComparator implements Comparator<Interval> {
    
    @Override
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
} 
public class CocurrentEvents {

}

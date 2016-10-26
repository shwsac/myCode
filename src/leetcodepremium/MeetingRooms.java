package leetcodepremium;

import java.util.PriorityQueue;
import java.util.Comparator;

/*
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {  
            
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start != b.start) {
                    return a.start - b.start;
                }
                return a.end - b.end;
            }
            
        });
        
        
        for(Interval i : intervals) {
            queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            Interval i = queue.poll();
            if(!queue.isEmpty()) {
                Interval j = queue.peek();
                if(i.end > j.start) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    //Better way
    // public boolean canAttendMeetings(Interval[] intervals) {
    //     Arrays.sort(intervals, new Comparator<Interval>(){
    //         public int compare(Interval a, Interval b){
    //             return a.start-b.start;
    //         }
    //     });
     
    //     for(int i=0; i<intervals.length-1; i++){
    //         if(intervals[i].end>intervals[i+1].start){
    //             return false;
    //         }
    //     }
     
    //     return true;
    // }
}

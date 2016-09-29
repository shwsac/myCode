package heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPoints {

    public Collection<Point> getClosestPoints(Collection<Point> points, int k) {
        
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            public int compare(Point p1,Point p2) {
                return (int)(p1.dist - p2.dist);
            }
        });
        
        for(Point point : points) {
            if(queue.size() < k) {
                queue.offer(point);
            }
            else {
                if(point.dist - queue.peek().dist < 0) {
                    queue.poll();
                    queue.offer(point);
                }
            } 
        }
        
        return queue;
    }
    
    public static void main(String[] args) {
        
        Collection<Point> points = new ArrayList<Point>();
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, 3, origin));
        points.add(new Point(-1, 1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));
        
        Collection<Point> closestPoints = new ClosestPoints().getClosestPoints(points, 5);
        System.out.print(closestPoints);
    }
}

class Point {
    
    int x;
    int y;
    double dist;
    
    Point(int x, int y, Point original) {
        this.x = x;
        this.y = y;
        this.dist = Math.hypot(x - original.x, y - original.y);
    } 
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return new String(" x: " + x + " y: " + y);
    }
}

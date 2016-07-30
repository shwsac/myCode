package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class UniquePaths {
    public int uniquePaths(int x, int y) {
        ArrayList<Point> path = new ArrayList<Point>();
        List<List<Point>> result = new ArrayList<List<Point>>();
        if(uniquePaths(x,y,path,result)) {
            return result.size();
        } 
        return 0;
        }

    public boolean uniquePaths(int x, int y, ArrayList<Point> path, List<List<Point>> result) {
        Point p = new Point(x,y);
        path.add(p);
        if(x==0 && y==0) {
            result.add(path);
            return true;
        }
        boolean success = false;
        if(x>=1) {
            success = uniquePaths(x-1,y,path,result);
        }
        if(y>=1) {
            success = uniquePaths(x,y-1,path,result);
        }
        if(!success) {
            path.remove(p);
        }
        return success;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

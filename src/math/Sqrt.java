package math;

public class Sqrt {
    public int mySqrt(int x) {
        
        if(x < 0 ) {
            return -1;
        }
        
        if(x == 0) {
            return 0;
        }
        
        if(x == 1) {
            return 1;
        }
        
        long low= 2;
        long high = x/2+1;
        
        while (low <= high) {
            long mid = (low + high) /2;
            if(mid * mid == x) {
                return (int)mid;
            }
            else if(mid * mid > x){
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return (int)high;
    }

}

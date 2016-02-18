package arrays;

public class ReverseInteger {
    
    public static int reverse(int x) {
        long revNum = 0;
        while (Math.abs(x) >= 1) {
            revNum = revNum * 10 + x % 10;
            x = x/10;
        }
        if (revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)revNum;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

}

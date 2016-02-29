package arrays;
public class Fibonacci {

    static int findFibonacci(int n) {
        if(n==0) {
            return 0;
        }
        int b = 0;
        int a = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            b = a;
            a = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            System.out.println(findFibonacci(i));
        }

    }

}

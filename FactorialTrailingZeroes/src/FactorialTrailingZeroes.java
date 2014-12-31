/**
 * Created by peimengqi on 15/1/1.
 * Given an integer n, return the number of trailing zeroes in n!.
 */

//解法：当0 < n < 5时，f(n!) = 0;
//当n >= 5时，f(n!) = k + f(k!), 其中 k = n / 5。
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        if(n < 5)
            return 0;

        return n/5 + trailingZeroes(n/5);
    }

//    unused
    public static int factorial(int n) {
        if(n == 1)
            return n;
        return factorial(n-1)*n;
    }

    public static void main(String[] args) {
        for (int i = 5; i <= 13; i++) {
            System.out.println(i+"!= "+factorial(i)+": "+trailingZeroes(i));
        }
    }
}

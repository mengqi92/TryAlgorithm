/**
 * Created by Mengqi on 15/6/7.
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * 260 ms
 */
public class Solution {
    public static int hammingWeight(int n) {
        //参考 ljp215 的代码(https://leetcode.com/discuss/36691/my-java-codes-cost-244ms)
        //将 n 转换为 long
        long nl = n;
        if(n < 0){
            nl = n & 0x7fffffff;
            nl |= 0x80000000L;
        }

        int weight = 0;
        while(nl != 0) {
            if(nl%2 != 0) weight++;
            nl >>>= 1;
        }
        return weight;
    }
}

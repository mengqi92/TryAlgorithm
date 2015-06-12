/**
 * Created by Mengqi on 15/6/12.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 232 ms
 */
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;//{1+1, 2}

        int Ways = 0,
            Ways_minus1 = 2, //Ways[2]
            Ways_minus2 = 1; //Ways[1]
        //起始从 2 开始（n==2之前已经判断过，这里 i=2 可以保证遍历所有未判断的位置）
        for(int i = 2; i < n; i++, Ways_minus2 = Ways_minus1, Ways_minus1 = Ways) {
            Ways = Ways_minus1 + Ways_minus2;
        }

        return Ways;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));
        System.out.println(solution.climbStairs(7));
    }
}

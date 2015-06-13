/**
 * Created by Mengqi on 15/6/13.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 264 ms
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int Ways[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j==0)//最左面一行
                    Ways[i][j] = i==0 ? 1 : Ways[i-1][j];
                else
                    Ways[i][j] = i==0 ? Ways[i][j-1] : Ways[i-1][j]+Ways[i][j-1];
            }
        }
        return Ways[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }
}

/**
 * Created by Mengqi on 15/6/13.
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     [
        [0,0,0],
        [0,1,0],
        [0,0,0]
     ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * 340 ms
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(m <= 0 || n <= 0) return 0;
        int Ways[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) continue; //障碍格不计算
                if(i == 0 && j == 0)//左上角格子初始化为 1
                    Ways[i][j] = 1;
                else if(j == 0 || obstacleGrid[i][j-1] == 1)//最左面一行或是左边有障碍挡住，只加上面过来的
                    Ways[i][j] = i==0 ? 0 : Ways[i - 1][j];//i==0表示左边有障碍，而改行已是最高行，因此路径数为0（因为 i==0 && j==0 已判断过，所以此处 i==0 一定有 j!=0）
                else if(i == 0 || obstacleGrid[i-1][j] == 1) //最上面一行或是上边有障碍挡住，只加左面过来的
                    Ways[i][j] = j==0 ? 0 : Ways[i][j - 1];
                else    //中间格子且左、上均无障碍
                    Ways[i][j] = Ways[i - 1][j] + Ways[i][j - 1];
            }
        }
        return Ways[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] obstacleGrid = {{1,0}};
//        int[][] obstacleGrid = {{0,0,1},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
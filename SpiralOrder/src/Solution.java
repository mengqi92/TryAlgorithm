import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mengqi on 15/2/10.
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<Integer>();
        if(matrix.length>0 && matrix[0].length>0)
            spiralList = spiralOrder(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        return spiralList;
    }

    private List<Integer> spiralOrder(int[][] matrix, int minrow, int maxrow, int mincol, int maxcol) {
        List<Integer> spiralList = new ArrayList<Integer>();

        if (maxrow < minrow || maxcol < mincol) {
            return spiralList;
        }

        int i=minrow, j=mincol;
        //向右
        for (; j <= maxcol; j++)
            spiralList.add(matrix[i][j]);
        //向下（多于一行）
        if (maxrow > minrow) {
            //此时j=maxcol+1,要弥补回来，j--
            //第一行已经遍历过，i++到第二行
            for (j--,i++; i <= maxrow; i++)
                spiralList.add(matrix[i][j]);
            //向左（多于一列）
            if (maxcol > mincol) {
                for (i--,j--; j >= mincol; j--)
                    spiralList.add(matrix[i][j]);
                //向上
                for (j++,i--; i > minrow; i--)
                    spiralList.add(matrix[i][j]);
            }
        }

        spiralList.addAll(spiralOrder(matrix, minrow + 1, maxrow - 1, mincol + 1, maxcol - 1));

        return spiralList;
    }

    public static void main(String[] args) {
//        int[][] matrix =    {{1,2,3,4},
//                            {5,6,7,8},
//                            {9,10,11,12}};

//        int[][] matrix = {{1}};
//        int[][] matrix = {{1,2},{3,4}};
        int[][] matrix = {{}};

        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+"->");
        }
    }
}

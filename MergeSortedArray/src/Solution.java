/**
 * Created by Mengqi on 15/3/28.
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    A[i] = B[i];
                }
                return;
            } else if (n == 0) {
                return;
            }
            //使用一个额外数组作为A的复制
            int C[] = new int[m];
            for (int i = 0; i < m; i++) {
                C[i] = A[i];
            }
            //i指向A，j->B, k->C
            for (int i = 0, j = 0, k = 0; i < m + n;) {
                if (j >= n) {
                    A[i++] = C[k++];
                } else if (k >= m) {
                    A[i++] = B[j++];
                }
                if (C[k] <= B[j]) {
                    A[i++] = C[k++];
                } else if (C[k] > B[j]) {
                    A[i++] = B[j++];
                }
            }
        for (int a : A) {
            System.out.print(a + ",");
        }
    }

    public static void main(String[] args) {
        int A[] = new int[8];
        for (int i = 0; i < 4; i++) {
            A[i] = 2 * i + 1;
        }
        int B[] = {9, 11, 13, 15};
        Solution solution = new Solution();

        for (int i = 0; i < 4; i++) {
            System.out.print(A[i]+",");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print(B[i]+",");
        }
        System.out.println();

        solution.merge(A, 4, B, 4);
    }
}

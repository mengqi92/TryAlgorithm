/**
 * Created by Mengqi on 15/3/28.
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 265ms
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
//            System.err.println("数组长度过小！");
            return;
        }
        if (k <= 0) {
//            System.err.println("K值过大。");
            return;
        }
        if (nums.length < k) {
            k = k%nums.length;
        }

        partialRotate(nums, 0, nums.length - 1);
        partialRotate(nums, 0, k - 1);
        partialRotate(nums, k, nums.length - 1);

        System.out.println("Final:");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + "->");
        }
        System.out.println(nums[nums.length - 1]);
    }

    private void partialRotate(int[] nums, int start, int end) {
        for (int i = start, j = end; i<j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
//        for (int i = start; i < end; i++) {
//            System.out.print(nums[i] + "->");
//        }
//        System.out.println(nums[end]);
    }

    public static void main(String[] args) {
//        int array[] = {1,2,3,4,5,6,7};
//        int array[] = {0};
        int array[] = {0,1};
        int k = 3;

        Solution solution = new Solution();
        solution.rotate(array, k);
    }
}

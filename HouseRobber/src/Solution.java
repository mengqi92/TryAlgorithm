/**
 * Created by Mengqi on 15/6/12.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * 280 ms
 */
public class Solution {
    //   迭代方法
    public int rob(int nums[]) {
        int length = nums.length;
        if(length == 0) return 0;
        else if(length == 1) return nums[0];
        else if(length == 2) return Math.max(nums[0], nums[1]);

        int M_minus2 = nums[0], //M[0]
            M_minus1 = Math.max(nums[0], nums[1]),//M[1]
            M = 0;          //M[i]
        for(int i = 2; i < length; i++, M_minus2 = M_minus1, M_minus1 = M) {
            M = Math.max(M_minus2+nums[i], M_minus1);
        }
        return M;
    }


//    递归方法
//    报 TimeOut(不知道为什么)
//    public int rob(int nums[]) {
//        int length = nums.length;
//        if(length == 0) return 0;
//        else if(length == 1) return nums[0];
//        else if(length == 2) return Math.max(nums[0] >= nums[1]);
//
//        int MoneyWithLastHouse = rob(nums,length-2)+nums[length-1];
//        int MoneyWithoutLastHouse = rob(nums,length-1);
//        return Math.max(MoneyWithLastHouse, MoneyWithoutLastHouse);
//    }
//
//    private int rob(int nums[], int length) {
//        if(length == 0) return 0;
//        else if(length == 1) return nums[0];
//        else if(length == 2) return Math.max(nums[0] >= nums[1]);
//
//        int MoneyWithLastHouse = rob(nums,length-2)+nums[length-1];
//        int MoneyWithoutLastHouse = rob(nums,length-1);
//        return Math.max(MoneyWithLastHouse, MoneyWithoutLastHouse);
//    }

    public static void main(String[] args) {
        int nums[] = {3, 6, 2, 3, 4};
//        int nums[] = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160, 165, 195, 187, 199, 114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

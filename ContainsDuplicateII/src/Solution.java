import java.util.HashMap;

/**
 * Created by Mengqi on 15/6/13.
 * Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * 456ms
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 0) return false;
        HashMap<Integer, Integer> noDupNumsWithLatestIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!noDupNumsWithLatestIndex.containsKey(nums[i]))
                noDupNumsWithLatestIndex.put(nums[i], i);
            else { //包含该数字
                if(i - noDupNumsWithLatestIndex.get(nums[i]) <= k)
                    return true;
                else
                    noDupNumsWithLatestIndex.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = {1,2,3,4,1,6,7,8,9,10};
        System.out.println(solution.containsNearbyDuplicate(nums, 2));
    }
}

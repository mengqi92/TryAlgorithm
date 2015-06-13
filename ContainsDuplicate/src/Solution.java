import java.util.HashSet;

/**
 * Created by Mengqi on 15/6/13.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 420ms
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        HashSet<Integer> noDupNums = new HashSet<Integer>();

        for(int num : nums) {
            if(noDupNums.contains(num))
                return true;
            else noDupNums.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int nums[] = {1,2,3,4,5,1};
//        int nums[] = {1,2,3,4,5};
        int nums[] = {1,1};
        System.out.println(solution.containsDuplicate(nums));
    }
}

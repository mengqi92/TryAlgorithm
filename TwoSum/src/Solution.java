import java.util.HashMap;

/**
 * Created by Mengqi on 15/4/25.
 *
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
    365 ms
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //存放<元素值 - 元素索引>键值对
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        //如果发生冲突，则存放在备用表里面
        HashMap<Integer, Integer> backTable = new HashMap<Integer, Integer>();

        Integer previousValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((previousValue = hashMap.put(nums[i], i)) != null) {
                backTable.put(nums[i], previousValue);
            }
        }

        int[] resultIndexes = new int[2];
        for (int index1 = 0, index2 = 1; index1 < nums.length - 1; ++index1) {
            if (target - nums[index1] == nums[index1]) {
                if (hashMap.get(nums[index1]) == index1) {
                    if (!backTable.containsKey(nums[index1]))
                        continue;
                    index2 = backTable.get(nums[index1]);
                } else {
                    if (!backTable.containsKey(nums[index1]))
                        continue;
                    index2 = hashMap.get(nums[index1]);
                }
            } else {
                if(!hashMap.containsKey(target - nums[index1]))
                    continue;
                index2 = hashMap.get(target - nums[index1]);
            }
            resultIndexes[0] = index1 < index2 ? index1+1 : index2+1;
            resultIndexes[1] = index1 < index2 ? index2+1 : index1+1;
        }

        return resultIndexes;
    }

    public static void main(String[] args) {
        int nums[] = new int[16022];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 2*i;
        }
        int target = 16021;

        Solution solution = new Solution();
        int[] indexes = solution.twoSum(nums, target);
        for (int i = 0; i < indexes.length; i++) {
            System.out.print(indexes[i] + ",");
        }
    }
}

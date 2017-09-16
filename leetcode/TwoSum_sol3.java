package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class TwoSum_sol3 {
	public int[] twoSum(int[] nums, int target){
		int len = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++){
			int complement = target - nums[i];
			if (map.containsKey(complement)){
				return new int[] {map.get(complement),i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

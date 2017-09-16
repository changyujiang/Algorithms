package leetcode;

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

class twoSum_sol1{
	public int[] twoSum(int[] nums, int target){
		int len = nums.length;
		for (int i = 0; i < len; i++){
			for (int j = i + 1; j < len; j++){
				if (nums[j] == target - nums[i]){
					return new int[] {i,j};
				}
			}
		}
		return new int[] {};
	}
}
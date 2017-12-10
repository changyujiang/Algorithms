package laicode.class15.dp3;


/*
Largest SubArray Sum
Given an unsorted integer array, find the subarray that has the greatest sum. 
Return the sum.

Assumptions
The given array is not null and has length of at least 1.

Examples
{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
{-2, -1, -3}, the largest subarray sum is -1*/

public class LargestSubarraySum {
	// 0. key point
	// unsorted array; subarray; largest sum

	// 1. assumption
	// array is not null, length at least 1

	// 2. approach
	// dp
	// linear scan hui tou kan

	// example a[]:
	// 2 -1 4 -2 1

	// dp[i] represents the largest sum of subarray[0,i](including i-th element)
	// base case
	// dp[0] = a[0]
	// dp[i] = dp[i-1] + a[i] if dp[i-1] > 0
	// dp[i] = a[i]

	// 3. data structure

	// 4. comment

	// 5. big o complexity
	// time: O(n)
	// space: O(1) since each time we only need to look one previous result, we
	// don't need to record all sub-solution.
	public int largestSum(int[] array) {
	    // array.length>=1
	    // 2, -1, 4, -6, 1
	    // 2  1   5  -1  1
	    
	    // initial state
	    int dp = array[0];
	    int max = dp;
	    
	    // 
	    for (int i = 1; i < array.length; i++) {
	      if (dp > 0) {
	        dp = dp + array[i];
	      } else {
	        dp = array[i];
	      }
	      max = Math.max(dp, max);
	    }
	    return max;
	  }
}

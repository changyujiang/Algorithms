package laicode.class13dp2;

/*Array Hopper II
Given an array A of non-negative integers, you are initially positioned at 
index 0 of the array. A[i] means the maximum jump distance from index i 
(you can only jump towards the end of the array). 
Determine the minimum number of jumps you need to reach the end of array. 
If you can not reach the end of the array, return -1.

Assumptions
The given array is not null and has length of at least 1.

Examples
{3, 3, 1, 0, 4}, the minimum jumps needed is 2 
(jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, 
return -1 in this case.*/

public class ArrayHopperII {
	// 0. key point
	// min jump from 0 to last index

	// 1. assumption
	// array.length >= 1

	// 2. approach
	// dp dp[i] represents minJump starting from index i
	// initial state: dp[array.length-1] == 0;
	// induction rule: dp[i] = dp[i+x] + 1 || dp[i+x-1] + 1 || ... || dp[i+1] +
	// 1
	// dp[i] = -1 if array[i] == 0;

	// 3. additional data structure

	// 4. comments

	// 5. BIG O COMPLEXITY
	// time: O(n^2)
	// space: O(n)
	public int minJump(int[] array) {
		// array.length >= 1
		int[] mj = new int[array.length];

		// init
		int n = array.length - 1;
		mj[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			int curMin = Integer.MAX_VALUE;
			for (int j = array[i]; j > 0; j--) {
				if (i + j <= n && mj[i + j] != -1) {
					curMin = Math.min(curMin, mj[i + j] + 1);
				}
			}
			mj[i] = curMin == Integer.MAX_VALUE ? -1 : curMin;
		}
		return mj[0];
	}
}

package laicode.class12dp1;

/*Array Hopper I
Given an array A of non-negative integers, you are initially 
positioned at index 0 of the array. A[i] means the maximum jump 
distance from that position (you can only jump towards the end of the array). 
Determine if you are able to reach the last index.

Assumptions
The given array is not null and has length of at least 1.

Examples
{1, 3, 2, 0, 3}, we are able to reach the end of array
(jump to index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array*/

public class ArrayHopperI {
	// 0. key point
	// jump from the O index to last index

	// 1. assumption
	// input array is not null not empty

	// 2. approach
	// dp
	// - cj[i] represents if we can jump to the last index from index i;
	// - initial state: cj[n-1] == true; assume the length of input is n
	// - induction rule:
	// - cj[i] = false, if input[i]==0;
	// - cj[i] = cj[i+1] || cj[i+2] || ... || cj[i+x], assume input[i] == x;

	// 3. data structure

	// 4. comments

	// 5. time complexity
	// time: O(n^2)
	// space: O(n)

	public boolean canJump(int[] array) {
		// assumption
		// array.length >= 1

		boolean[] cj = new boolean[array.length];
		// initial state
		int n = array.length - 1;
		// n >= 0
		cj[n] = true;

		// i >= -1
		for (int i = n - 1; i >= 0; i--) {
			boolean curRes = false;
			for (int j = 1; j <= array[i]; j++) {
				int tempIndex = i + j;
				if (tempIndex <= n) {
					curRes = curRes || cj[tempIndex];
				}
			}
			cj[i] = curRes;
		}
		return cj[0];
	}
}

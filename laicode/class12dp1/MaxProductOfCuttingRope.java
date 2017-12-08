package laicode.class12dp1;

/*Max Product Of Cutting Rope
Given a rope with positive integer-length n, how to cut the rope into 
m integer-length parts with length p[0], p[1], ...,p[m-1], in order to 
get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by 
you and must be greater than 0 (at least one cut must be made). 

Return the max product you can have.

Assumptions
n >= 2

Examples
n = 12, the max product is 3 * 3 * 3 * 3 = 81
(cut the rope into 4 pieces with length of each is 3).*/

public class MaxProductOfCuttingRope {
	// recursion method
	// base case: length == 1; mp = 0;
	// Complexity:
	// time: O(n^n)
	public int maxProductRecursion(int length) {
		// base case
		if (length == 1) {
			return 0;
		}

		int max = 0;
		// for i = 1 to n-1
		for (int i = 1; i < length; i++) {
			int right = Math.max(length - i, maxProduct(length - i));
			max = Math.max(max, i * right);
		}

		return max;
	}

	// 0. key point
	// cut a integer-length rope into multiple integer-length parts
	// get the max multiplication of each part length

	// 1. assumption
	// n >= 2

	// 2. approach
	// DP
	// mp[i] represents the max product of length i's rope
	// base case:
	// mp[2] = 1
	// mp[1] = 0;
	// induction rule: mp[i] = max( max(j, mp[j]) * i-j ) for j = 1 .. i-1

	// 3. data structure

	// 4. comments

	// 5. Big O complexity
	// time: two loops O(n^2)
	// space: O(n)
	public int maxProduct(int length) {

		int[] mp = new int[length + 1];

		// base case
		mp[2] = 1;

		//
		for (int i = 3; i < length + 1; i++) {
			int thisMax = 0;
			for (int j = 1; j < i; j++) {
				int left = Math.max(j, mp[j]);
				thisMax = Math.max(thisMax, left * (i - j));
			}
			mp[i] = thisMax;
		}

		return mp[length];
	}
}

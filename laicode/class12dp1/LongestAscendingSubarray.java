package laicode.class12dp1;

/*Longest Ascending SubArray
Given an unsorted array, find the length of the longest subarray 
in which the numbers are in ascending order.

Assumptions
The given array is not null

Examples
{7, 2, 3, 1, 5, 8, 9, 6}, 
longest ascending subarray is {1, 5, 8, 9}, length is 4.
{1, 2, 3, 3, 4, 4, 5}, 
longest ascending subarray is {1, 2, 3}, length is 3.*/

public class LongestAscendingSubarray {
	// 0. key point
	// unsorted array, subarray

	// 1. assumption
	// array of integers
	// duplicate?
	// ascending? > or >= (non-decreasing)

	// 2. approach
	// dp method
	// m[i] represents longest ascending subarray from the first element to i-th
	// element
	// initial state
	// m[0] = 1;
	// induction rule:
	// m[i] = m[i-1] + 1 if input[i]>input[i-1];
	// m[i] = 1 otherwise
	// our goal is find the largest from m[0..n-1]

	// 3. data sturcture

	// 4. comments

	// 5. complexity
	// time: O(n)
	// space: O(1)

	// example:
	// {7, 2, 3, 1, 5, 8, 9, 6}
	// linear scan, hui tou kan
	public int longest(int[] array) {
		// input is not null
		if (array.length == 0) {
			return 0;
		}
		// m[0]
		int m = 1;
		int max = m;

		// fill m[1 .. n-1]
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				m++;
			} else {
				m = 1;
			}
			max = Math.max(m, max);
		}

		return max;
	}
}

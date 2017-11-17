package laicode.class18;

import java.util.Arrays;
/* Array Deduplication I

Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value keep only one of them. 
Do this in-place, using the left side of the original array and maintain 
the relative order of the elements of the array. 

Return the array after deduplication.

Assumptions:
The array is not null

Examples:
{1, 2, 2, 3, 3, 3} → {1, 2, 3}*/

/*
 * key points:
 * 		sorted array, it means that duplicate items must be adjacent;
 * 		then, we can use two pointers to scan them in one pass.
 */

public class ArrayDeduplicationI {
	// for this kind of problem, we can use two pointers to scan the array
	// from left to right
	// slow, to the left of slow (inclusive) is what we want to return
	// fast, the current

	// assumption:
	// 1. the array is not null
	// 2. if array is empty, return array
	public int[] dedup(int[] array) {
		// corner case
		if (array.length <= 1) {
			return array;
		}
		// init
		int slow = 0;
		int fast = 1;
		// example
		// 0 1 2 3 4 5 len
		// 1 2 3 3 3 3 
		//     s
		//             f
		while (fast < array.length) {
			if (array[fast] != array[slow]) {
				array[++slow] = array[fast++];
			} else {
				fast++;
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}
}

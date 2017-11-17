package laicode.class18;

import java.util.Arrays;


/*Array Deduplication II
Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value keep at most two of them. 
Do this in-place, using the left side of the original array and maintain 
the relative order of the elements of the array. 
Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}*/

/*
 * KEY POINTS:
 * sorted array, it means that duplicate items must be adjacent
 * keep at most two of them
 * keep the relative order, it means that two pointers in same direction 
 * is applicable.
 */

public class ArrayDeduplicationII {
	// key point: sorted array,
	// idea: two pointers
	// slow, to the left of slow (inclusive) is what we want to return
	// fast, current
	public int[] dedup(int[] array) {
		// assumption
		// array is not null
		// if array is empty return it

		// corner case
		if (array.length <= 2) {
			return array;
		}

		// example
		// 0 1 2 3 4 5 len
		// 1 2 2 3 3 3
		//           s
		//             f
		// init
		int slow = 1;
		int fast = 2;

		while (fast < array.length) {
			if (array[fast] != array[slow - 1]) {
				array[++slow] = array[fast++];
			} else {
				fast++;
			}
		}

		return Arrays.copyOf(array, slow + 1);
	}
}

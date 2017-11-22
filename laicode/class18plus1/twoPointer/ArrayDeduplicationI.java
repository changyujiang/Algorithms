package laicode.class18plus1.twoPointer;

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
	  // 1. assumption: 
	  // the array is not null
	  // if array is empty, return array
	  
	  // 2. approach:
	  // use two pointers in the same direction, slow and fast
	  // left of slow (inclusive) is what we want to return, all item processed
	  // between slow and fast is dont care area
	  // right to fast is unexplored area
	  
	  // in each iteration, we compare array[fast] and array[slow], if they are different
	  // array[++slow] = array[fast++]
	  // otherwise fast++;
	  
	  // 3. comment where it applicable
	  // 4. Big O complexity
	  // time: O(n)
	  // space: O(1)
	  // 5. identity data structure
	  
	  public int[] dedup(int[] array) {
	    // corner case
	    if (array == null || array.length <= 1) {
	      return array;
	    }
	    // init 
	    // slow(inclusive); at least we need to return 1 elment
	    int slow = 0;
	    int fast = 1;
	    // example
	    // 1 2 2 3 3 3 len
	    // s
	    //   f
	    
	    // terminate condition: fast = array.length
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

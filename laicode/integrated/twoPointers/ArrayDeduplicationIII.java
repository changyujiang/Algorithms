package laicode.integrated.twoPointers;

import java.util.Arrays;

/* Data Structure
Array Deduplication III

Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value do not keep any of them. 
Do this in-place, using the left side of the original array and and 
maintain the relative order of the elements of the array. 
Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 2, 3, 3, 3} → {1}*/

public class ArrayDeduplicationIII {
	  // 0. keypoints:
	  // sorted array, don't keep any of them,
	  // inplace, realtive order counts
	  
	  // 1. assupmtion:
	  // given array is not null
	  // if array is empty, do nothing
	  
	  // 2. approach:
	  // two pointers, slow and first in the same direction
	  // left of slow(inclusive) is what we want to return
	  // init: slow = -1, we cannot ensure that there must be at least one item returned.
	  // fast = 0;
	  // each iteration we check # of array[f]
	  // example:
	  //  0 1 2 3 4 5 l
	  //  1 2 2 3 3 3
	  //s 
	  //        f
	  //    b
	  // f - b == 1 copy array[b] to array[++slow]
	  // else continue
	  
	  // 3. Comments applicable
	  
	  // 4. Big O complexity
	  // time: one pass O(n)
	  // space: O(1)
	  
	  // 5. additional data structure if necessary
	  public int[] dedup(int[] array) {
	    // corner case
	    if (array.length == 0) {
	      return array;
	    }
	    // init
	    int slow = -1;
	    int fast = 0;
	    while (fast < array.length) {
	      int begin = fast;
	      while (fast < array.length && array[fast] == array[begin]) {
	        fast++;
	      }
	      // if only one item(no duplicate) copy, otherwise continue
	      if (fast - begin == 1) {
	        array[++slow] = array[begin];
	      } 
	    }
	    
	    return Arrays.copyOf(array, slow + 1);
	  }
}

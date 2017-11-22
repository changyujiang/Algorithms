package laicode.class18plus1.twoPointer;

import java.util.Arrays;
/*Data Structure
 Array Deduplication IV
 Given an unsorted integer array, remove adjacent duplicate elements repeatedly,
 from left to right. 
 For each group of elements with the same value do not keep any of them.

 Do this in-place, using the left side of the original array. 
 Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}*/
public class ArrayDeduplicationIV {
	  // 0. keypoints:
	  // unsorted array; adjacent duplicate repeatedly
	  // inplace
	  
	  // 1. assumption:
	  // input is not null
	  // if input is empty, do nothing
	  
	  // 2. approach:
	  // inplicitly stack to do it
	  // two pointers, slow, fast, the left of slow(inclusive) is what we want to return
	  // we use the left part of array as a stack, slow is top of stack
	  // expamle:
	  //  1 2 3 3 3 2 2
	  //  s
	  //                f
	  
	  // 3. comments
	  
	  // 4. Big O complexity
	  // time: one pass O(n)
	  // space: O(1)
	  
	  // 5. additional data structure
	  public int[] dedup(int[] array) {
	    // corner case
	    if (array.length <= 1) {
	      return array;
	    }
	    
	    // init: stack is empty
	    int slow = -1;
	    int fast = 0;
	    
	    while (fast < array.length) {
	      if (slow == -1 || array[slow] != array[fast]) {
	        array[++slow] = array[fast++];
	      } else {
	        while (fast < array.length && array[slow] == array[fast]) {
	          fast++;
	        }
	        slow--;
	      }
	    }
	    return Arrays.copyOf(array, slow + 1);
	  }
}

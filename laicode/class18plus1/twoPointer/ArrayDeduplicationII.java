package laicode.class18plus1.twoPointer;

import java.util.Arrays;

/*
Array Deduplication II
Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value keep at most two of them. 
Do this in-place, using the left side of the original array and 
maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}*/

public class ArrayDeduplicationII {
	  // 0. key points: 
	  // sorted input array;
	  // keep at most two, in-place, relative order required
	  
	  // 1. assumption:
	  // array is not null;
	  // if array is empty, do nothing
	  
	  // 2. approach:
	  // two pointers, slow and fast, left of slow(inclusive), right of fast
	  // init: slow = 1 (at least we can return two items) fast = 2
	  // each iteration: 
	  // if (array[slow - 1] == array[fast]) fast++;
	  // else array[++slow] = array[fast++];
	  // termination: fast = array.length (all items scaned)
	  
	  // 3. comments where applicable
	  
	  // 4. big O complexity
	  // time: O(n)
	  // space: O(1)
	  
	  //5. additional data structure if necessary
	  
	  public int[] dedup(int[] array) {
	    // corner case
	    if (array.length <= 2) {
	      return array;
	    }
	    
	    // example
	    // 0 1 2 3 4 5 len
	    // 1 2 2 3 3 3
	    //         s
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

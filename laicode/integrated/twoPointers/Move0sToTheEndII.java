package laicode.integrated.twoPointers;
/*Data Structure
Move 0s To The End II
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array need to be maintained.

Assumptions:
The given array is not null.

Examples:
{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}*/
public class Move0sToTheEndII {
	  // 0. keypoint:
	  // relative order counts
	  // 1. assupmiton:
	  // input array is not null
	  // if input is empty, do nothing
	  
	  // 2. approach:
	  // two pointers, slow and fast, the left of slow(inclusive) are all non-zeros,
	  // between slow(exclusive) and fast(exclusive) are zeros
	  // init: slow = -1 fast = 0
	  // termination: fast = array.length
	  // in each iteration: if array[fast] = 0 fast++;
	  // else slow++; swap(slow, fast); fast++
	  
	  // 3. comments
	  
	  // 4. Big O complexity
	  // time: ONE PASS O(N)
	  // space: O(1)
	  
	  // 5. additional data structures
	  public int[] moveZero(int[] array) {
	    // corner case
	    if (array == null || array.length == 0) {
	      return array;
	    }
	    
	    // init
	    int slow = -1;
	    int fast = 0;
	    
	    while (fast < array.length) {
	      if (array[fast] != 0) {
	        slow++;
	        swap(array, slow, fast);
	        fast++;
	      } else {
	        fast++;
	      }
	    }
	    
	    return array;
	  }
	  
	  private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }	
}

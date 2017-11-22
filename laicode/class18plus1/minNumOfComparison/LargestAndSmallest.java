package laicode.class18plus1.minNumOfComparison;

/*
Largest And Smallest

Use the least number of comparisons to get the largest and smallest number 
in the given integer array. 
Return the largest number and the smallest number.

Assumptions
The given array is not null and has length of at least 1

Examples
{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. 
return [5, 1].*/

public class LargestAndSmallest {
	  // 0. keypoint
	  // least number of comparsions;
	  // largest and smallest number
	  
	  // 1. assumption
	  // input is not null; 
	  // input length at least 1;
	  
	  // 2. approach
	  // naive method: 2n times comparison to find largest and smallest
	  // two pointers, left and right, oppsite direction
	  // init left = 0; right = length - 1;
	  // termination left >= right
	  // each iteration, compare left,right swap them if necessary (put larger one
	  // to left part, smaller one to right part);
	  // find largest one from left part n/2
	  // find smallest one from right part (if length is odd) n/2
	  
	  // 3. comments
	  
	  // 4. BIG O complexity
	  // time: O(n) 1.5n
	  // space: O(1)
	  public int[] largestAndSmallest(int[] array) {
	    // length >= 1
	    int left = 0;
	    int right = array.length - 1;
	    int mid = (right - left) / 2;
	    while (left < right) {
	      if (array[left] < array[right]) {
	        swap(array, left, right);
	      }
	      left++;
	      right--;
	    }
	    
	    int max = array[0];
	    for (int i = 1; i <= mid; i++) {
	      if (array[i] > max) {
	        max = array[i];
	      }
	    }
	    
	    int min = array[array.length - 1];
	    for (int i = mid; i < array.length; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      }
	    }
	    
	    return new int[]{max, min};
	  }
	  
	  private void swap (int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }
}

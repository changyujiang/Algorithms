package laicode.class1;
/*Selection Sort
Given an array of integers, sort the elements in the array in ascending order. 
The selection sort algorithm should be used to solve this problem.

Examples:
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases:
What if the given array is null? 
	In this case, we do not need to do anything.
What if the given array is of length zero? 
	In this case, we do not need to do anything.*/

public class SelectionSort {
	public int[] selectionSort(int[] array) {
	    // 1. assumption: 
	    // if array is null or empty, return array;
	    // 2. approach:
	    // selection sort, 
	    // divide the input array into two parts;
	    // sorted and unsorted, say left and right
	    // each iteration we selected a minimum item from the unsorted part
	    // and put it to sorted part
	    
	    // corner case
	    if (array == null || array.length == 0) {
	      return array;
	    }
	    // demo 
	    // {4, 2, -3, 6, 1} 
	    //  i
	    // {-3, 1, 2, 4, 6}
	    for (int i = 0; i < array.length; i++) {
	      // find min from unsorted part
	      int minIndex = i;
	      for (int j = i + 1; j < array.length; j++) {
	        if (array[j] < array[minIndex]) {
	          minIndex = j;
	        }
	      }
	      // swap it to sorted part
	      swap(array, i, minIndex);
	    }
	    return array;
	  }
	  
	  private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	    return;
	  }
	  // 3. complexity
	  // time: there are n iterations for a array with length to sort the whole 
	  // array, and for each iteration, we need at most n comparsion operations;
	  // so, the time complexity is O(n^2)
	  // space: we do it in-place O(1)
}

package laicode.fundamental.sorting;
/*Merge Sort
Given an array of integers, sort the elements in the array in ascending order. 
The merge sort algorithm should be used to solve this problem.

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

public class MergeSort {
	public int[] mergeSort(int[] array) {
	    // 1.assumption
	    // if array is null or empty, do nothing, return array
	    // 2. approach
	    // merge sort algorithm
	    // each time we divide the array into two parts, until the size is one, say
	    // we can slove the base case in O(1)
	    // then, we merge the sub-answer to build a full answer
	    // 4. complexity
	    // time
	    //                          4 2 -3 6 1
	    //              4 2 -3                        6 1
	    //        4 2         -3                6              1
	    //     4     2        
	    //                              n                        divide O(1) merge O(n)
	    //                  n/2                   n/2            divide O(2) merge O(n)
	    //             n/4       n/4           n/4       n/4     divide O(4) merge O(n)
	    //         n/8    n/8  n/8    n/8   n/8   n/8  n/8  n/8  divide O(8) merge O(n)    
	    //       ....
	    //      1   1     1  1   1  1  ...                  1 1  divide O(n) merge O(n)
	    //  the tree height is logn, total time is O(nlogn)
	    // space
	    // the helper int array O(n)
	    
	    
	    // corner cases
	    if (array == null || array.length == 0) {
	      return array;
	    }
	    // example
	    // 4, 2, -3, 6, 1
	    
	    // helper int array for merge operation
	    int[] helper = new int[array.length];
	    mergeSort(array, helper, 0, array.length - 1);
	    return array;
	  }
	  
	  private void mergeSort(int[] array, int[] helper, int l, int r) {
	    // base case
	    if (l >= r) {
	      return;
	    }
	    // instead of (l + r) / 2, we use following way to avoid overflow
	    int mid = l + (r - l) / 2;
	    // divide into two subproblem;
	    // (l,mid) (mid+1,r); how to divide is important
	    mergeSort(array, helper, l, mid);
	    mergeSort(array, helper, mid + 1, r);
	    // example: 
	    // if l,r = (7, 9) mid = 8, then (l, mid) = (7,8)[2] (mid+1, r) = (9,9)[1]
	    // if l,r = (7, 8) mid = 7, then (l, mid) = (7,7)[1] (mid+1, r) = (8,8)[1]
	    // l = r, return
	    // if l,r = (7, 7) mid = 7, then (l, mid) = (7,7)[1] (mid+1, r) = (8,7)[0]
	    
	    // merge up (l < r)
	    merge(array, helper, l, r, mid);
	  }
	  
	  private void merge(int[] array, int[] helper, int l, int r, int mid) {
	    for (int i = l; i <= r; i++) {
	      helper[i] = array[i];
	    }
	    // init, i is index of left part subarray, j is index of right part subarray
	    int i = l;
	    int j = mid + 1;
	    // cur index
	    int cur = l;
	    while (i <= mid && j <= r && cur <= r) {
	      array[cur++] = helper[i] <= helper[j] ? helper[i++] : helper[j++];
	    }
	    // if we still have some elments in left side, we need to copy them
	    while (i <= mid) {
	      array[cur++] = helper[i++];
	    }
	    // if we have some elments in right side, we dont need to copy them
	    // becasue they are already in their position
	    // example: 
	    // array[]  123 145 
	    //helper[]  123 145
	    // result   112 345
	    //while (j <= r) {
	    //  array[cur++] = helper[j++];
	    //}
	    return;
	  }
}

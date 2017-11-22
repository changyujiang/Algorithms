package laicode.class18plus1.minNumOfComparison;

import java.util.ArrayList;
import java.util.List;

/*Largest And Second Largest
Use the least number of comparisons to get the largest and 
2nd largest number in the given integer array. 
Return the largest number and 2nd largest number.

Assumptions
The given array is not null and has length of at least 2

Examples
{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.*/

public class LargestAndSecondLargest {
	  // 0. keypoints 
	  // least # of comparisons;
	  // largest and 2nd largest number
	  
	  // 1. assumption
	  // length of array >=2
	  
	  // 2. approach
	  // each iteration, 
	  // use two pointers, left and right to scan the array from two ends
	  // compare left and right and swap the larger one to the left part
	  // also record compared values for left part elements
	  // after iteration, divide the array into one half
	  
	  // 3. comments
	  
	  // 4. BIG O complexity
	  // time: O(n)
	  // space: O(n)
	  // # of comparison : n for largest number, logn for second largest
	  
	  // 5. additional data structure
	  // since we need to stored the compared values
	  // we created an object Elment to helpe to do it.
	  
	  // example:
	  // 2    1    5 4 3               len = 5
	  // 3(2) 4(1) 5 1 2               len+1/2 = 3
	  // 5(3)                          len+1/2 = 2
	  // 5(3 4)
	  
	  //
	  static class Element {
	    int value;
	    List<Integer> comparedValues;
	    
	    Element(int value) {
	      this.value = value;
	      this.comparedValues = new ArrayList<>();
	    }
	  }
	  
	  public int[] largestAndSecond(int[] array) {
	    Element[] e = convert(array);
	    int largerLength = array.length;
	    while (largerLength > 1) {
	      compareAndSwap(e, largerLength);
	      largerLength = (largerLength + 1) / 2;
	    }
	    
	    return new int[]{e[0].value, largest(e[0].comparedValues)};
	  }
	  
	  private void compareAndSwap(Element[] e, int largerLength) {
	    // if length = 6; i < 3
	    // if length = 5; i < 2
	    for (int i = 0; i < largerLength / 2; i++) {
	      if (e[i].value < e[largerLength - 1 - i].value) {
	        swap(e, i, largerLength - 1 - i);
	      }
	      e[i].comparedValues.add(e[largerLength - 1 - i].value);
	    }
	  }
	  
	  private void swap (Element[] e, int i, int j) {
	    Element temp = e[i];
	    e[i] = e[j];
	    e[j] = temp;
	  }
	  
	  private int largest (List<Integer> list) {
	    int max = list.get(0);
	    for (int i :  list) {
	      max = Math.max(max, i);
	    }
	    return max;
	  }
	  
	  private Element[] convert (int[] array) {
	    // array length >= 1
	    Element[] res = new Element[array.length];
	    for (int i = 0; i < array.length; i++) {
	      res[i] = new Element(array[i]);
	    }
	    return res;
	  }
}

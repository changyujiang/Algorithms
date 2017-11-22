package laicode.class16ProbSampleRandom;

public class Shuffle {
	  // shuffle problem is a kind of permutation problem
	  // say n = input array length
	  // we can generate a k-permuatation from small to large (1 to n)
	  // when k = 1, randomly select a item from the input array, i.e. use 
	  // random() * n to get the index of randomly selected item, the probability of each item is 1/n
	  // and swap it with the last index
	  // when k = 2, randomly selected an item from first n-1 entries, and swap it to the end,
	  // the probability of the resulting 2-permutation is 1/n*(n-1)
	  // and so on..
	  // when k = k, ...
	  
	  // 0. key point
	  // array without duplicate, shuffle
	  // all permutation equally likely to be generated
	  
	  // 1. assumption
	  // array is not null, no duplicate
	  
	  // 2. approach
	  // divide array into two part, left, unselected; right selected
	  // each time, randomly select a item and swap it to right
	  // so we can increasingly build a k permutation to n permutation
	  // say, k = 1, probability is 1/n
	  // k = 2, 1/(n)(n-1)
	  // k = 3, 1/(n)(n-1)(n-2)
	  // ...
	  // k = n, 1/n!
	  
	  // 3. data structure
	  
	  // 4. comment
	  
	  // 5. big o complexity
	  // time: O(n)
	  // space: O(1)
	  public void shuffle(int[] array) {
	    // corner case ()
	    if (array == null || array.length == 0) {
	      return;
	    }
	    int n = array.length;
	    for (int i = 0; i < n; i++) {
	      int random = (int) (Math.random() * (n - i));
	      swap(array, random, n - i - 1);
	    }
	  }
	  
	  private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	    return;
	  }
}

package laicode.class18plus1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecifiedOrder {
	  // 0. keypoints
	  // sort a1 according to a2
	  
	  // 1. assumption
	  // a1 a2 not null
	  // a2 no duplicates
	  
	  // 2. approach
	  // design a comparator accroding to A2 and sort A1
	  
	  // 3. data structure
	  
	  // 4. comment
	  
	  // 5. big O complexity
	  // time: O(nlogn) java use quick sort for objects
	  // space: O(m) length of A2
	  public int[] sortSpecial(int[] A1, int[] A2) {
	    Integer[] a1 = convertToInteger(A1);
	    Arrays.sort(a1, new myComparator(A2));
	    convertToInt(a1, A1);
	    return A1;
	  }
	  
	  private void convertToInt(Integer[] a, int[] b) {
	    for (int i = 0; i < a.length; i++) {
	      b[i] = a[i];
	    }
	  }
	  
	  private Integer[] convertToInteger(int[] a) {
	    Integer[] b = new Integer[a.length];
	    for (int i = 0; i < a.length; i++) {
	      b[i] = a[i];
	    }
	    return b;
	  }
	  
	  static class myComparator implements Comparator<Integer> {
	    private Map<Integer, Integer> map;
	    
	    public myComparator(int[] a) {
	      map = new HashMap<>();
	      for (int i = 0; i < a.length; i++) {
	        map.put(a[i], i);
	      }
	    }
	    
	    @Override
	    public int compare(Integer a1, Integer a2) {
	      Integer i1 = map.get(a1);
	      Integer i2 = map.get(a2);
	      if (i1 != null && i2 != null) {
	        return i1.compareTo(i2);
	      } else if (i1 == null && i2 == null) {
	        return a1.compareTo(a2);
	      }
	      return i1 != null ? -1: 1;
	    }
	  }
}

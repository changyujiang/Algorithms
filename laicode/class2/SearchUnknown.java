package laicode.class2;

public class SearchUnknown {
	public int search(Dictionary dict, int target) {
	    //corner case
	    if (dict == null || dict.get(0) == null) {
	      return -1;
	    }   
	    int left = 0;
	    int right = findRight(dict, target);
	    while (left <= right) {
	      int mid = (left + right) / 2;
	      if (dict.get(mid) == null) {
	        right = mid - 1;
	      } else if (dict.get(mid) == target) {
	        return mid;
	      } else if (dict.get(mid) < target) {
	        left = mid + 1;
	      } else if (dict.get(mid) > target) {
	        right = mid - 1;
	      }
	    }
	    return -1;
	  }
	  
	  public int findRight(Dictionary dict, int target) {
	    if (dict.get(0) == target){
	      return 0;
	    }
	    int index = 1;
	    while (dict.get(index) != null && dict.get(index) < target) {
	      index = index * 2;
	    }
	    return index;
	  }
}

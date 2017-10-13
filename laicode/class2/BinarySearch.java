package laicode.class2;

public class BinarySearch {
	public int binarySearch(int[] nums, int target){
		// corner case
		if (nums == null || nums.length == 0 ){
		return -1;
	}

	int left = 0;
	int right = nums.length - 1;

	while (left <= right) {
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			right = mid - 1;
		} else if (nums[mid] < target) {
			left = mid + 1;
		}
	}

	return -1;
	}
	
	
}

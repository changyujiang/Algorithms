package laicode.class2;

public class FirstOccurrence {
	public int firstOccurrence(int[] nums, int target) {
		// corner case
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		// terminate the loop while left neighbors right
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				right = mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (nums[left] == target) {
			return left;
		} else if (nums[right] == target) {
			return right;
		}

		return -1;
	}
}

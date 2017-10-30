package leetcode.facebook;

/**
 * Given 
 * input: nums = [0, 1, 0, 3, 12]
 * output: nums = [1, 3, 12, 0, 0]
 */
public class MoveZeros {
	public void moveZeros(int[] nums) {
		// corner case
		if (nums == null || nums.length == 0 ){
			return;
		}
		
		// [1, 3, 0, 0, 12, 15]
		//        i      j
		// two pointers
		// left of it are non-zero elements
		// right of it are 
		// the other is the current
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 0) {
				continue;
			}
			swap(nums, i, j);
			i++;
		}
		return;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

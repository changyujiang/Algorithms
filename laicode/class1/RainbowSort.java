package laicode.class1;

public class RainbowSort {
	public int[] rainbowSort(int[] nums) {
		// numbers left to i, [,i) all -1
		// numbers between i and j, [i,j) all 0
		// numbers right to k, (k,] all 1
		// numbers between j and k, [j,k] unknown area
		
		// corner case
		if (nums.length == 0 || nums.length == 1 || nums == null){
			return nums;
		}
		
		// initialization
		int i = 0;
		int j = 0;
		int k = nums.length - 1;

		while (j <= k) {
			if (nums[j] == -1) {
				swap(nums, i++, j);
			} else if (nums[j] == 0) {
				j++;
			} else if (nums[j] == 1) {
				swap(nums, j, k--);
			}
			
			if (i > j){
				j = i;
			}
		}
		return nums;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return;
	}
}

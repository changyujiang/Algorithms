package laicode.class2;

public class KCloest {
	public int[] kCloest(int[] nums, int target, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}

		int left = 0;
		int right = nums.length - 1;
		int closest;
		int[] res = new int[k];

		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				closest = mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		if (Math.abs(nums[left] - target) <= Math.abs(nums[right] - target)) {
			closest = left;
		} else {
			closest = right;
		}
		res[0] = nums[closest];
		
		int L = closest - 1;
		int R = closest + 1;
		for (int i = 1; i < k; i++) {
			if (L >= 0 && R <= nums.length - 1) {
				res[i] = Math.abs(nums[L] - target) <= Math.abs(nums[R]- target) ? nums[L--] : nums[R++];
			} else if (L < 0) {
				res[i] = nums[R++];
			} else {
				res[i] = nums[L--];
			}
		}
		
		return res;
	}
}

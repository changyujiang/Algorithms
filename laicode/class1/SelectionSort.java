package laicode.class1;

public class SelectionSort {
	public int[] selectionSort(int[] nums) {
		if (nums == null || nums.length == 0){
			return nums;
		}
		
		for (int i = 0; i < nums.length - 1; i++){
			int min = i;
			for (int j = i + 1; j < nums.length; j++){
				if (nums[j] < nums[min]){
					min = j;
				}
			}
			swap(nums, i, min);
		}
		
		return nums;
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return;
	}
}

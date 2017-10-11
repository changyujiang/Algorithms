package laicode.class1;

public class QuickSort {
	public int[] quickSort(int[] nums) {
		if (nums == null || nums.length == 0){
			return nums;
		}
		quickSort(nums, 0, nums.length - 1);
		
		return nums;
	}

	public void quickSort(int[] nums, int left, int right){
		if (left >= right) {
			return;
		}

		int pivot_pos = partition(nums, left, right);

		quickSort(nums, left, pivot_pos - 1);
		quickSort(nums, pivot_pos + 1, right);
	}

	public int partition(int[] nums, int left, int right){
		//quickSort can be done in-place
		int pivot = left + (int) (Math.random() * (right - left + 1));
		int pivotValue = nums[pivot];
		
		// swap(nums,left,pivot);
		// why swap to rightmost
		swap(nums,right,pivot);
		//
		int i = left;
		int j = right - 1;
		
		while (i <= j){
			if (nums[i] < pivotValue){
				i++;
			}
			else if (nums[j] >= pivotValue){
				j--;
			}
			/*
			else if (nums[i] >= nums[left]){
				swap(nums,i,j);
				j--;
				i++;
			}
			else if (nums[j] < nums[left]){
				swap(nums,j,i);
				i++;j--;
			*/
			else {
				swap(nums,i++,j--);
			} 	
		}
		
		swap(nums,i,right);
		
		return i;
	}

	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

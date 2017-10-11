package laicode.class1;

public class MergeSort {
	public int[] mergeSort(int[] nums){
		// corner case
    	if (nums == null || nums.length == 0){
      		return nums;
    	}

    	int[] helper = new int[nums.length];
    	mergeSort(nums,helper,0,nums.length-1);
    	return nums;	
  	}

	public void mergeSort(int[] nums, int[] helper, int left, int right){
		//base case included
		if(left >= right) return;
		
		int mid = (left + right) / 2;
		mergeSort(nums,helper,left,mid);
		mergeSort(nums,helper,mid+1,right);
		merge(nums,helper,left,mid,right);
	}

	public void merge(int[] nums, int[] helper, int left, int mid, int right){
		for (int i = left; i <= right; i++){
			helper[i] = nums[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;
	
		while (leftIndex <= mid && rightIndex <= right){
			if(helper[leftIndex] <= helper[rightIndex])
				nums[left++] = helper[leftIndex++];
			else 
				nums[left++] = helper[rightIndex++];
		}
	
		while (leftIndex <= mid){
			nums[left++] = helper[leftIndex++];
		}
	}
}

package laicode.class1;

import java.util.Arrays;

public class SortTesting {
	
	public static void main(String[] args){
		MergeSort solution1 = new MergeSort();
		QuickSort solution2 = new QuickSort();
		//test cases
		int[] nums;
		nums = null;
		nums = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = null;
		nums = solution2.quickSort(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[0];
		nums = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[0];
		nums = solution2.quickSort(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[]{2,54,32,545,-1};
		nums = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[]{2,54,32,545,-1};
		nums = solution2.quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
}

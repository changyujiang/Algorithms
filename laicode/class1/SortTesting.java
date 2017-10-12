package laicode.class1;

import java.util.Arrays;

public class SortTesting {
	
	public static void main(String[] args){
		MergeSort solution1 = new MergeSort();
		QuickSort solution2 = new QuickSort();
		SelectionSort sol3 = new SelectionSort();
		//test cases
		int[] nums;
		int[] res;
		nums = null;
		res = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(res));
		res = solution2.quickSort(nums);
		System.out.println(Arrays.toString(res));
		res = sol3.selectionSort(nums);
		System.out.println(Arrays.toString(res));
		
		nums = new int[0];
		res = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(res));
		res = solution2.quickSort(nums);
		System.out.println(Arrays.toString(res));
		res = sol3.selectionSort(nums);
		System.out.println(Arrays.toString(res));
		
		
		nums = new int[]{2,54,32,545,-1};
		res = solution1.mergeSort(nums);
		System.out.println(Arrays.toString(res));
		res = solution2.quickSort(nums);
		System.out.println(Arrays.toString(res));
		res = sol3.selectionSort(nums);
		System.out.println(Arrays.toString(res));
		
		nums = new int[]{-1,0,1,1,-1,0};
		nums = new int[]{1,1};
		RainbowSort sol4 = new RainbowSort();
		res = sol4.rainbowSort(nums);
		System.out.println(Arrays.toString(res));
	}
	
}

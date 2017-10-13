package laicode.class2;

import java.util.Arrays;

public class Class2Test {
	public static void main(String[] args){
		BinarySearch sol = new BinarySearch();
		FirstOccurrence sol2 = new FirstOccurrence();
		KCloest sol3 = new KCloest();
		 
		int[] nums = {1, 2, 2, 2, 3, 4};
		int res;
		res = sol.binarySearch(nums, 2);
		System.out.println(res);
		res = sol2.firstOccurrence(nums, 2);
		
		int[] res1;
		
		int[] nums1 = {1,5};
		res1 = sol3.kCloest(nums1, 2, 1);
		System.out.println(Arrays.toString(res1));
		
		SearchUnknown sol4 = new SearchUnknown();
		int target;
		Dictionary dict;
		dict = new DictImpl(new int[] {1,3,4,4,5,6,10,12,15,17,18});
		target = 10;
		System.out.println("Expected: 6, Actual: " + sol4.search(dict, target));
		
		dict = new DictImpl(largeArray(100000));
		target = 99999;
		System.out.println("Expected: 99999, Actual: " + sol4.search(dict, target));
		
		dict = new DictImpl(new int[0]);
		target = 1;
		System.out.println("Expected: -1, Actual: " + sol4.search(dict, target));
		
		dict = new DictImpl(new int[]{0,1,2,3,4});
		target = 5;
		System.out.println("Expected: -1, Actual: " + sol4.search(dict, target));
	}
	
	public static int[] largeArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++){
			array[i] = i;
		}
		return array;
	}
}

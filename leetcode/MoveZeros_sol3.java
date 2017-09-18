package leetcode;

public class MoveZeros_sol3 {
	public void moveZeroes(int[] nums){
        if (nums == null || nums.length == 0) return;
        
		int insertPos = 0;
		for (int i = 0; i<nums.length; i++){
			if (nums[i] != 0){
                int temp = nums[insertPos];
                nums[insertPos++] = nums[i];
                nums[i] = temp;
			}
		}
	}
}

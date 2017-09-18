package leetcode;

public class MoveZeroes_sol1 {
	    public void moveZeroes(int[] nums) {
	        int len = nums.length;
	        for (int i = len-2; i>=0; i--){
	            if (nums[i]==0){
	                while (i < len-1 && nums[i+1]!=0 ){
	                    exc(nums,i,i+1);
	                    i++;
	                }
	            }
	        }
	    }
	    
	    public void exc(int[] nums, int i, int j){
	        int aux = nums[i];
	        nums[i] = nums[j];
	        nums[j] = aux;
	    }
}

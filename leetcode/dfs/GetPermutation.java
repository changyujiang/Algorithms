package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GetPermutation {
    public String getPermutation(int n, int k) {
        if (n == 0){
            return "";
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        
        List<int[]> myList = new ArrayList<>();
        helper(nums, 0, k, myList);
        String ans = Arrays.toString(myList.get(k - 1));
        //String ans = Arrays.toString(myList.get(k - 1)).replaceAll("\\[|\\]|,|\\s", "");
        return ans;
    }
    
    public void helper(int[] nums, int level, int k, List<int[]> myList){
        if (level == nums.length - 1){
            myList.add(nums);
            return;
        }
        /*
        if (myList.size() == k){
            return;
        }
        */
        for (int i = level; i < nums.length; i++){
        	swap2(nums, level, i);
            helper(nums, level + 1, k, myList);
            swap2(nums, level, i);
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
    }
    
    public void swap2(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j){
        int left = i;
        i = j - 1;
        while (i >= left){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i--;
        }
    }
    
    public static void main(String[] args){
    	GetPermutation solu = new GetPermutation();
    	String ans = solu.getPermutation(2, 2);
    	String ans2 = solu.getPermutation(2, 1);
    	System.out.println(ans);
    	System.out.println(ans2);
    }
}